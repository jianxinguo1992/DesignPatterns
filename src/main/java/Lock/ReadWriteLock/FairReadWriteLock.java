package Lock.ReadWriteLock;

import Lock.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JIANXIN.GUO
 * @date 2019-05-02 15:48
 **/
public class FairReadWriteLock implements ReadWriteLock {


    private final java.util.concurrent.locks.Lock lock;

    private final java.util.concurrent.locks.Condition existReadCondition;

    private final java.util.concurrent.locks.Condition existWriteCondition;

    private final Lock readLock;

    private final Lock writeLock;

    private volatile boolean write;

    private volatile int readAccquired;

    private volatile int readReleased;

    public FairReadWriteLock(){
        lock = new ReentrantLock(true);
        existReadCondition = lock.newCondition();
        existWriteCondition = lock.newCondition();
        readLock = new ReadLock();
        writeLock = new WriteLock();
        write = false;
        readAccquired = 0;
        readReleased = 0;
    }

    @Override
    public Lock readLock() {
        return new ReadLock();
    }

    @Override
    public Lock writeLock() {
        return new WriteLock();
    }


    private class ReadLock implements Lock{

        @Override
        public void lock() {
            lock.lock();
            try{
                while(write){
                    try {
                        existWriteCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted");
                    }
                }
                readAccquired ++;
            }finally{
                lock.unlock();
            }
        }

        @Override
        public void unlock() {
            lock.lock();
            try{
                readReleased ++;
                if(readReleased == readAccquired){
                    existReadCondition.signalAll();
                }
            }finally{
                lock.unlock();
            }
        }

    }

    private class WriteLock implements Lock{

        @Override
        public void lock() {
            lock.lock();
            try{
                while(write){
                    try {
                        existWriteCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted");
                    }
                }
                // 让新加入的读锁不能增加readAccquired
                write = true;
                while(readAccquired != readAccquired){
                    try {
                        existReadCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted");
                    }
                }
            }finally{
                lock.unlock();
            }
        }

        @Override
        public void unlock() {
            lock.lock();
            try{
                write = false;
                existWriteCondition.signalAll();
            }finally{
                lock.unlock();
            }
        }

    }




}

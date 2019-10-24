package Lock.ReentrantLock;

import Lock.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JIANXIN.GUO
 * @date 2019-05-02 16:55

 * 简单的可重入锁实现，使用一个计数器记录当前线程重入锁的次数，获得锁时计数器加1，释放锁时计数器减1，
 * 当计数器等于0时表示释放了锁
 **/
public class SimpleReentrantLock implements Lock {


    // 指向已经获得锁的线程
    private volatile Thread exclusiveOwnerThead;

    // 记录获取了同一个锁的次数
    private volatile int holdCount;

    private final java.util.concurrent.locks.Lock lock;

    // 是否是自己获得锁的条件
    private final Condition isCountZero;

    public SimpleReentrantLock(){
        lock = new ReentrantLock();
        isCountZero = lock.newCondition();
        holdCount = 0;
    }

    @Override
    public void lock() {
        lock.lock();

        try {
            Thread currentThread = Thread.currentThread();
            if (exclusiveOwnerThead  == currentThread){
                holdCount ++;
                return;
            }

            while (holdCount != 0){
                try {
                    isCountZero.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted");
                }
            }

            exclusiveOwnerThead = currentThread;
            holdCount ++;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void unlock() {
        lock.lock();
        try {
            holdCount --;
            if (holdCount == 0){
                isCountZero.signalAll();
            }
        } finally {
            lock.unlock();
        }

    }
}

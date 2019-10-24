package Lock.TASLock;

import Lock.Lock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-13 16:13
 **/
public class TASLock implements Lock {

    private AtomicBoolean mutex = new AtomicBoolean(false);

    @Override
    public void lock() {
        // getAndSet方法会设置mutex变量为true，并返回mutex之前的值
        // 当mutex之前是false时才返回，表示获取锁
        // getAndSet方法是原子操作，mutex原子变量的改动对所有线程可见
        while(mutex.getAndSet(true)){

        }
    }
    @Override
    public void unlock() {
        mutex.set(false);
    }
}

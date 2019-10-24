package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-14 15:55
 **/
public interface TryLock {

    void lock();

    void lockInterruptibly() throws InterruptedException;

    boolean tryLock();

    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    void unlock();

    Condition newCondition();



}

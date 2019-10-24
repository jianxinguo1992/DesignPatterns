package Lock.TASLock;

import Lock.Lock;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-13 16:54
 **/
public class BackoffLock implements Lock {

    private final int MIN_DELAY, MAX_DELAY;

    public BackoffLock(int min, int max){
        MIN_DELAY = min;
        MAX_DELAY = max;
    }

    private AtomicBoolean mutex = new AtomicBoolean(false);

    @Override
    public void lock() {
        Backoff backoff = new Backoff(MIN_DELAY, MAX_DELAY);
        while (true){
            while (mutex.get()){
                if (!mutex.getAndSet(true)){
                    return;
                }else {
                    try {
                        backoff.backoff();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void unlock() {
        mutex.set(false);
    }
}

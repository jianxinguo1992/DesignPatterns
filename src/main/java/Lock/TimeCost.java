package Lock;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-14 13:58
 **/
public class TimeCost implements Lock {
    private final Lock lock;

    public TimeCost(Lock lock){
        this.lock = lock;
    }

    static Queue array = new ArrayBlockingQueue(1);

    @Override
    public void lock() {
        long start = System.nanoTime();
        lock.lock();
        long duration = System.nanoTime() - start;
        System.out.println(lock.toString() + " time cost is " + duration + " ns");
    }

    @Override
    public void unlock() {
        lock.unlock();
    }


}

package Lock.BlockingArray;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-27 14:06
 **/
public class BlockingArrayWithCondition<T> {

    private final T[] array;

    private int head;

    private int tail;

    private int count;

    private java.util.concurrent.locks.Lock lock = new ReentrantLock();

    private Condition isFull = lock.newCondition();

    private Condition isEmpty = lock.newCondition();

    public BlockingArrayWithCondition(int size){
        array = (T[]) new Object[size];
    }

    public void put(T item) throws InterruptedException {
        lock.lock();

        try {
            while (count == array.length){
                isFull.await();
            }

            array[tail] = item;
            if (++tail == array.length){
                tail = 0;
            }

            count ++;
            System.out.println("Add item :" + item);
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                isEmpty.await();
            }

            T item = array[head];

            if (++head == array.length){
                head =0;
            }

            count --;

            System.out.println("Take item : " + item);
            isFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }
}

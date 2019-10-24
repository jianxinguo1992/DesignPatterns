package Lock.ReadWriteLock;

import Lock.Lock;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JIANXIN.GUO
 * @date 2019-05-02 14:01
 **/
public class TestReadWriteLock {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        TreeMap<String, String> treeMap = new TreeMap<String, String>(String::compareTo);
        CountDownLatch countDownLatch = new CountDownLatch(28);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 28; i++) {
            if (i % 7 == 0){
                new Thread(() -> {
                    Lock writeLock = new SimpleReadWriteLock().writeLock();
                    writeLock.lock();
                    try {
                        Thread.sleep(new Random().nextInt(3000));
                        ++count;
                        treeMap.put(LocalDateTime.now().toString() +" "+ atomicInteger.getAndIncrement(), "write   "+ count + "  "+Thread.currentThread().getName());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                        writeLock.unlock();
                    }
                }, "thread-"+ i).start();
            } else {
                new Thread(() -> {
                    Lock readLock = new SimpleReadWriteLock().readLock();
                    readLock.lock();
                    try {
                        Thread.sleep(new Random().nextInt(3000));
                        treeMap.put(LocalDateTime.now().toString() +" "+ atomicInteger.getAndIncrement(), "read   "+ count + "  "+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                        readLock.unlock();
                    }
                }, "thread-"+ i).start();
            }
        }
        countDownLatch.await();
        treeMap.forEach((k, v) ->{
            System.out.println(k + "    " +v);
        });
    }
}

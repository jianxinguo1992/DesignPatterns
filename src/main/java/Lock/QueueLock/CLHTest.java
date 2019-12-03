package Lock.QueueLock;

import Lock.Lock;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-14 13:53
 **/
public class CLHTest {

//    private static Lock lock = new TimeCost(new CLHLock());

//    private static Lock lock = new ArrayLock(150);

    private static Lock lock = new CLHLock();

//    private static TimeCost lock = new TimeCost(new TTASLock());

    private static volatile int value = 0;
    public static void method(){
        lock.lock();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Value: " + ++value);
        lock.unlock();
    }

    public static void main(String[] args) {

//        Backoff backoff = new Backoff(1,3);
//        SizeOf sizeOf = SizeOf.newInstance();
//        long l = sizeOf.sizeOf(backoff);
//        System.out.println(l);
//        for(int i = 0; i < 100; i ++){
//            Thread t = new Thread(new Runnable(){
//
//                @Override
//                public void run() {
//                    method();
//                }
//
//            });
//            t.start();
//        }
    }
}

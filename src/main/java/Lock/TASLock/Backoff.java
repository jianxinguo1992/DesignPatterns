package Lock.TASLock;

import java.util.Random;

/**
 * @author JIANXIN.GUO
 * @date 2019-04-13 16:53
 **/
public class Backoff {
    private final int minDelay, maxDelay;

    private int limit;

    final Random random;

    public Backoff(int min, int max){
        this.minDelay = min;
        this.maxDelay = max;
        limit = minDelay;
        random = new Random();
    }

    // 回退，线程等待一段时间
    public void backoff() throws InterruptedException{
        int delay = random.nextInt(limit);
        limit = Math.min(maxDelay, 2 * limit);
        Thread.sleep(delay);
    }
}

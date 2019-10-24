package Lock.ReadWriteLock;

import Lock.Lock;

/**
 * @author JIANXIN.GUO
 * @date 2019-05-01 11:01
 **/
public interface ReadWriteLock {

    Lock readLock();

    Lock writeLock();
}

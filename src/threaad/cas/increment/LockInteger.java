package threaad.cas.increment;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInteger implements IncrementInteger{

    private int value;
    Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try{
            value++;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public int get() {
        return value;
    }
}

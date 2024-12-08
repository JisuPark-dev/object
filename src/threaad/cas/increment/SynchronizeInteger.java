package threaad.cas.increment;

public class SynchronizeInteger implements IncrementInteger{

    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}

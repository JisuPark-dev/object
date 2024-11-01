package threaad.start;

public class CounterThreadMain {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }
}

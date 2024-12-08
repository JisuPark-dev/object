package threaad.cas.increment;

import java.util.ArrayList;
import java.util.List;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class IncrementThreadMain {
    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new SynchronizeInteger());
        test(new LockInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                sleep(10); // 너무 빨리 실행되기 때문에 다른 스레드와 동시실행을 위해서 멈춘다.
                incrementInteger.increment();
            }
        };
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        for(Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();
        System.out.println(incrementInteger.getClass().getSimpleName() + " result : " + result);


    }
}

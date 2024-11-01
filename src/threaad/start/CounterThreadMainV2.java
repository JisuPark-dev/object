package threaad.start;

import static java.lang.Thread.sleep;
import static threaad.util.MyLogger.log;

public class CounterThreadMainV2 {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while(true) {
                try {
                    log("A");
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread threadB = new Thread(() -> {
            while(true) {
                try {
                    log("B");
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}

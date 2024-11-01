package threaad.start;

import static threaad.util.MyLogger.log;

public class CounterThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                log("value: "+i);
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

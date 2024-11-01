package threaad.start;

import static threaad.util.MyLogger.log;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        log("run()");
    }
}

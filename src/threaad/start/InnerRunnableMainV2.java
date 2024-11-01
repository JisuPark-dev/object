package threaad.start;

import static threaad.util.MyLogger.log;

public class InnerRunnableMainV2 {
    public static void main(String[] args) {
        log("main() start");
        Runnable myRunnable = new Runnable(){
            @Override
            public void run() {
                log("run()");
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();
        log("main() end");

    }
}

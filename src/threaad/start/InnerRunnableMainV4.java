package threaad.start;

import static threaad.util.MyLogger.log;

public class InnerRunnableMainV4 {
    public static void main(String[] args) {
        log("main() start");
        Thread thread = new Thread(() -> log("run()"));
        thread.start();
        log("main() end");

    }
}

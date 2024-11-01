package threaad.control;

import static threaad.util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "my thread");
        log("myThread.state1 = "+thread.getState());
        log("myThread.start()");
        thread.start();
        log("myThread.state2 = "+thread.getState());
    }
    static class  MyRunnable implements Runnable {

        @Override
        public void run() {
            log("start");
            log("myThread.state3 = "+Thread.currentThread().getState());
        }
    }
}

package threaad.control.interrupt;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();
        sleep(4000);
        log("작업 중단 지시 runFlag = false");
        myTask.runFlag = false;
        thread.interrupt();
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true; // volatile , 여러 스레드에서 공유하는 값.

        @Override
        public void run() {
            try {
                while (runFlag) {
                    log("작업 中");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 = "+Thread.currentThread().isInterrupted());
                log("interrupted msg : "+ e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업 종료");
        }
    }
}

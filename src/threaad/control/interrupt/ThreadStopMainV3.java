package threaad.control.interrupt;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();
        sleep(400);
        log("작업 중단 지시 runFlag = false");
        myTask.runFlag = false;
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = "+thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true; // volatile , 여러 스레드에서 공유하는 값.

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                log("작업 中");
            }
            log("work 스레드 인터럽트 상태2 = "+Thread.currentThread().isInterrupted());
            try {
                log("자원 정리");
                // work thread의 인터럽트 상태가 계속 true로 유지되기 때문에 sleep을 만났을 때 예외가 발생한다.
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태 3 = "+ Thread.currentThread().isInterrupted());
            }

            log("작업 종료");
        }
    }
}

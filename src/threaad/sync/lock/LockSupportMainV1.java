package threaad.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "parkTest");
        thread1.start();
        sleep(1000);

        log("thread1 state : " + thread1.getState());

//        log("main -> unpark(thread1)");
//        LockSupport.unpark(thread1);
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(10000000);
            log("park 종료, state: "+ Thread.currentThread().getState());
            log("인터럽트 상태: "+Thread.currentThread().isInterrupted());
        }
    }
}

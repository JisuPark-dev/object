package threaad.cas.spinlock;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class SpinLockMainV1 {
    public static void main(String[] args) {
        SpinLock spinLockBad = new SpinLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                spinLockBad.lock();
                //
                try {
                    log("비즈니스 로직 실행");
                    sleep(1);
                } finally {
                    spinLockBad.unlock();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        t1.start();
        t2.start();

    }
}

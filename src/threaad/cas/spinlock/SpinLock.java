package threaad.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class SpinLock {

    private final AtomicBoolean locked = new AtomicBoolean(false);
    public void lock() {
        log("락 획득 시도");
        while(!locked.compareAndSet(false, true)) {
            log("락 획득 실패 - 스핀 대기");
        }
        log("락 획득 완료");
    }

    public void unlock() {
        locked.set(false);
        log("락 반납 완료!");
    }
}

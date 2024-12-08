package threaad.cas.spinlock;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class SpinLockBad {
    private volatile  boolean lock = false; // lock에 대한 flag

    public void lock() {
        log("락 획득 시도");
        while (true) {
            if (!lock) {
                sleep(100);//  문제 상황 확인용, 스레드 대기
                lock = true;
                break;
            }else{
                log("락 획득 실패. 스핀 대기");
            }
        }
        log("락 획득 완료");


    }

    public void unlock() {
        lock = false;
        log("락 반납 완료!");
    }
}

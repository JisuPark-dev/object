package threaad.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class BoundedQueueV3 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while(queue.size() == max) {
            log("큐의 사이즈가 가득참, 버림: " + data);
            try {
                wait();
                log("[put] 생산자 께어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        log("[put] 생산자 데이터 저장, notify() 호출");
        notify();
    }

    @Override
    public synchronized String take() {
        while(queue.isEmpty()) {
            log("[take] 큐에 데이터 없음, 소비자 대기");
            try {
                wait();
                log("[take] 소비자 께어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String poll = queue.poll();
        log("[take] 소비자 데이터 획득, notify() 호출");
        notify(); 
        return poll;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}

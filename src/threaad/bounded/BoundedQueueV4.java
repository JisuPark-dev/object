package threaad.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static threaad.util.MyLogger.log;

public class BoundedQueueV4 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV4(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try {
            while(queue.size() == max) {
                log("큐의 사이즈가 가득참, 버림: " + data);
                try {
                    condition.await();
                    log("[put] 생산자 께어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("[put] 생산자 데이터 저장, notify() 호출");
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String take() {
        lock.lock();
        try{
            while(queue.isEmpty()) {
                log("[take] 큐에 데이터 없음, 소비자 대기");
                try {
                    condition.await();
                    log("[take] 소비자 께어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            String poll = queue.poll();
            log("[take] 소비자 데이터 획득, notify() 호출");
            condition.signal();
            return poll;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}

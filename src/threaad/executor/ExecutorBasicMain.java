package threaad.executor;

import java.util.concurrent.*;

import static threaad.executor.ExecutorUtils.printState;
import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class ExecutorBasicMain {
    public static void main(String[] args) {
        //LinkedBlockingQueue 무제한으로 넣을 수 있다.
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("== 초기 상태==");
        printState(es);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));

        log("== 작업 수행 중 ==");
        printState(es);

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        es.close();
        log("== 셧다운 완료 ==");
        printState(es);
    }
}

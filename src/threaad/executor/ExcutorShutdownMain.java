package threaad.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static threaad.executor.ExecutorUtils.printState;
import static threaad.util.MyLogger.log;

public class ExcutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTask", 100_0000000));
        printState(es);
        log("== shutdown 시작");
        shutdownAndAwaitTermination(es);
        log("== shutdown 완료");
    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {
        es.shutdown(); // non-blocking , 새로운 작업 받지 않음. 처리중이거나 이미 대기중인 작업은 처리한다. 이후에 풀을 종료한다.

        try {
            //이미 대기중인 작업들을 모두 완료할 때까지 기다린다.
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                //정상 종료가 너무 오래걸리면
                log("서비스 정상 종류 실패! 강제 종료를 시도하겠습니다");
                es.shutdownNow();
                //작업이 취소될 때 까지 대기한다.
                if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                    log("서비스가 종료되지 않았습니다");
                }

            }
        } catch (InterruptedException e) {
            // awaitTermination으로 대기중인 현재 스레드가 인터럽트 될 수 있다.
            es.shutdownNow();
        }
    }
}

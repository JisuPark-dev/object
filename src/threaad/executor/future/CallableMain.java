package threaad.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        log("result : " + result);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() {
            log("Callable 시작");
            sleep(2000);
            int v = new Random().nextInt(10);
            log("create value");
            log("Callable 종료");
            return v;
        }
    }
}

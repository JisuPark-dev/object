package threaad.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static threaad.util.MyLogger.log;

public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService) {
        //ExecutorService 는 자세한 인터페이스 제공하지 않아서 ThreadPoolExecutor를 사용해야합니다.
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();

            log("[pool=" + poolSize+ ", active= " + activeCount + ", queued=" + queued + ", completedTaskCount=" + completedTaskCount + "]");
        }else{
            log(executorService);
        }
    }

    public static void printState(ExecutorService executorService, String taskName) {
        //ExecutorService 는 자세한 인터페이스 제공하지 않아서 ThreadPoolExecutor를 사용해야합니다.
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();

            log(taskName + " => [pool=" + poolSize+ ", active= " + activeCount + ", queued=" + queued + ", completedTaskCount=" + completedTaskCount + "]");
        }else{
            log(executorService);
        }
    }


}

package threaad.executor;

import static threaad.util.MyLogger.log;

public class RunnableTask implements Runnable{

    private final String name;
    private int sleepMs = 10000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        log(sleepMs); // 작업시간을 시뮬레이션 해보는 것임.
        log(name + " 완료");
    }
}

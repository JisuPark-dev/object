package threaad.volatile1;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread t = new Thread(myTask);
        log("main start()");
        t.start();
        sleep(1000);
        myTask.flag = false;
        log("myTask.flag = false로 수정");
        log("flag = " + myTask.flag+", count = " + myTask.count + " in main");
        log("main end()");

    }
    static class MyTask implements Runnable {

        volatile boolean flag = true;
        volatile long count = 0;

        @Override
        public void run() {
            while (flag) {
                count++;
                if (count % 100000000 == 0) {
                    log("flag = " + flag+", count = " + count + " in while()");
                }
            }
            log("flag = " + flag+", count = " + count + " 종료");
        }
    }
}

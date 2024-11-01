package threaad.control.join;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class JoinMainV2 {
    public static void main(String[] args) throws InterruptedException {
        log("start");
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);
        Thread thread1 = new Thread(sumTask1);
        Thread thread2 = new Thread(sumTask2);
        thread1.start();
        thread2.start();
//        sleep(3000);
        thread1.join();
        thread2.join();
        log(sumTask1.result + sumTask1.result);
        log("end");
    }


    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for(int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }

        public int getResult() {
            return result;
        }
    }
}

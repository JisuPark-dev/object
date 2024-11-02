package threaad.sync;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccountV1 account1 = new BankAccountV1(1000);

        WithdrawTask t1 = new WithdrawTask(account1, 800);
        WithdrawTask t2 = new WithdrawTask(account1, 800);

        Thread thread1 = new Thread(t1, "t1");
        Thread thread2 = new Thread(t2,"t2");

        thread1.start();
        thread2.start();

        sleep(500);
        log("t1 state : " + thread1.getState());
        log("t2 state : " + thread2.getState());

        thread1.join();
        thread2.join();

        log("최종 잔액 : "+ account1.getBalance());
    }
}

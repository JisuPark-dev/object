package threaad.sync;

import static threaad.util.MyLogger.log;
import static threaad.util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {

    private int balance; // 잔고

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());

        // == 임계영역 시작 ==
        synchronized (this) {
            // 잔고가 출금액보다 적으면 , return false
            log("[검증 시작] 출금액 : " + amount + ", 잔액: "+ balance);
            if(balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액: "+ balance);
                return false;
            }
            //잔고가 출금액보다 많으면 진행.
            log("[검증 완료] 출금액 : " + amount + ", 잔액: "+ balance);
            sleep(1000);
            balance -= amount;
            log("[출금 완료] 출금액 : " + amount + ", 잔액: "+ balance);
            // == 임계영역 종료 ==
        }

        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

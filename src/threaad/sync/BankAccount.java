package threaad.sync;

public interface BankAccount {
    boolean withdraw(int amount); // 출금금액 매게변수로 받아서 출금실행.

    int getBalance();
}

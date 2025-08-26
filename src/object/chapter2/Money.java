package object.chapter2;

import java.math.BigDecimal;

public class Money {

  private final BigDecimal amount;
  public static final Money ZERO = Money.wons(0);
  public static Money wons(long amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public static Money wons(double amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public Money(BigDecimal amount) {
    this.amount = amount;
  }

  public Money plus(Money amount) {
    return new Money(this.amount.add(amount.amount));
  }

  public Money minus(Money amount) {
    return new Money(this.amount.subtract(amount.amount));
  }

  public Money times(double percent) {
    return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
  }

  public boolean isLessThan(Money amount) {
    return this.amount.compareTo(amount.amount) < 0;
  }
  public boolean isGreaterThanOrEqual(Money amount) {
    return this.amount.compareTo(amount.amount) >= 0;
  }
}

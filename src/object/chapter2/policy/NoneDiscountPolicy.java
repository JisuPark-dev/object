package object.chapter2.policy;

import object.chapter2.Money;
import object.chapter2.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {


  @Override
  protected Money getDiscountAmount(Screening screening) {
    return Money.ZERO;
  }
}

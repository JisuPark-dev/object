package object.chapter2.policy;

import object.chapter2.Money;
import object.chapter2.Screening;
import object.chapter2.condition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy{
  private Money discountAmount;

  public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
    super(conditions);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return discountAmount;
  }

}

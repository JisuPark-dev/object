package object.chapter2.policy;

import object.chapter2.Money;
import object.chapter2.Screening;
import object.chapter2.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy{
  private double percent;

  public PercentDiscountPolicy(double percent,
      DiscountCondition... conditions) {
    super(conditions);
    this.percent = percent;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return screening.getMovieFee().times(percent);
  }
}

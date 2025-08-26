package object.chapter2.policy;

import java.util.Arrays;
import java.util.List;
import object.chapter2.Money;
import object.chapter2.Screening;
import object.chapter2.condition.DiscountCondition;

public abstract class DiscountPolicy {
  private List<DiscountCondition> conditions;

  public DiscountPolicy(DiscountCondition... conditions) {
    this.conditions = Arrays.asList(conditions);
  }

  public Money calculateDiscountAmount(Screening screening) {
    for (DiscountCondition condition : conditions) {
      if (condition.isSatisfiedBy(screening)) {
        return getDiscountAmount(screening);
      }
    }
    return Money.ZERO;
  }

  abstract protected Money getDiscountAmount(Screening screening);


}

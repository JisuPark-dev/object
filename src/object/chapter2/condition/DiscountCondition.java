package object.chapter2.condition;

import object.chapter2.Screening;

public interface DiscountCondition {
  boolean isSatisfiedBy(Screening screening);

}

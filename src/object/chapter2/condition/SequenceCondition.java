package object.chapter2.condition;

import object.chapter2.Screening;

public class SequenceCondition implements DiscountCondition {
  private int sequence;

  public SequenceCondition(int sequence) {
    this.sequence = sequence;
  }

  public boolean isSatisfiedBy(Screening screening) {
    return screening.isSequence(sequence);
  }

}

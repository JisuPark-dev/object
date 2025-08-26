package object.chapter2.condition;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import object.chapter2.Screening;

public class PeriodCondition implements DiscountCondition {
  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public boolean isSatisfiedBy(Screening screening) {
    return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
        startTime.compareTo(screening.getStartTime().toLocalTime()) <=0&&
        endTime.compareTo(screening.getStartTime().toLocalTime()) >=0;
  }
}

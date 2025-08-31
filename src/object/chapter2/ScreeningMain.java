package object.chapter2;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import object.chapter2.condition.PeriodCondition;
import object.chapter2.condition.SequenceCondition;
import object.chapter2.policy.AmountDiscountPolicy;
import object.chapter2.policy.NoneDiscountPolicy;
import object.chapter2.policy.PercentDiscountPolicy;

public class ScreeningMain {

  public static void main(String[] args) {
    Movie avatar = new Movie("아바타",
        Duration.ofMinutes(120),
        Money.wons(10000),
        new AmountDiscountPolicy(
        Money.wons(800),
        new SequenceCondition(1),
        new SequenceCondition(10),
        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))));

    Movie titanic = new Movie("타이타닉",
        Duration.ofMinutes(180),
        Money.wons(11000),
        new PercentDiscountPolicy(0.1,
            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59)),
            new SequenceCondition(1)));

    Movie starWars = new Movie("스타워즈", Duration.ofMinutes(210), Money.wons(10000),
        new NoneDiscountPolicy());

  }

}

package object.chapter1;

public class Theater {

  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience) {
    ticketSeller.sellTo(audience); // audience, ticketSeller 코드가 변경되더라도 theater 코드는 동일
  }

}

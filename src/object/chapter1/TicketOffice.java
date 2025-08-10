package object.chapter1;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
  private Long amount;
  private List<Ticket> tickets = new ArrayList<>();

  public TicketOffice(Long amount, Ticket... tickets) {
    this.tickets.addAll(List.of(tickets));
    this.amount = amount;
  }

  public Ticket getTicket() {
    return tickets.remove(0);
  }

  public void minusAmount(Long amount) {
    this.amount -= amount;
  }

  public void plusAmount(Long amount) {
    this.amount += amount;
  }

}

package object.chapter1;

public class Bag {

  private Ticket ticket;
  private Invitation invitation;
  private Long amount;

  public Bag(Long amount) {
    this(null, amount);
  }

  public Bag(Invitation invitation, Long amount) {
    this.invitation = invitation;
    this.amount = amount;
  }

  public Long hold(Ticket ticket) {
    if (hasInvitation()) {
      this.setTicket(ticket);
      return 0L;
    } else {
      minusAmount(ticket.getFee());
      this.setTicket(ticket);
      return ticket.getFee();
    }
  }

  public boolean hasInvitation() {
    return invitation != null;
  }
  public boolean hasTicket() {
    return ticket != null;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public void minusAmount(Long amount) {
    this.amount -= amount;
  }

  public void plusAmount(Long amount) {
    this.amount += amount;
  }

}

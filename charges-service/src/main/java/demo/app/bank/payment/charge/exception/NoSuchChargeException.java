package demo.app.bank.payment.charge.exception;

public class NoSuchChargeException extends Exception {
  public NoSuchChargeException() {
    super("Unable to find the charge for the given reference since it was not exist");
  }
}

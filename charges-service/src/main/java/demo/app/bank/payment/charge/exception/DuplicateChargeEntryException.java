package demo.app.bank.payment.charge.exception;

public class DuplicateChargeEntryException extends Exception {
  public DuplicateChargeEntryException() {
    super("Unable to save this charge entry due to the duplicate entry violation");
  }
}

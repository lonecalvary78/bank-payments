package demo.app.bank.payment.charge.model.error;

public record ApplicationError(int statusCode, String reason) {
  public static ApplicationError of(int statusCode, String reason) {
    return new ApplicationError(statusCode, reason);
  }
}

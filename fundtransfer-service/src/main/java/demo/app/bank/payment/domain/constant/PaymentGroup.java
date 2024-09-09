package demo.app.bank.payment.domain.constant;

public enum PaymentGroup {
  INTERNAL_TRANSFER("internal"),
  INTERBANK_TRANSFER("interbank");

  private final String paymentGroupCode;

  PaymentGroup(String paymentGroupCode) {
    this.paymentGroupCode = paymentGroupCode;
  }

  public static PaymentGroup of(String paymentGroupCode) {
    switch (paymentGroupCode) {
      case "internal": return INTERNAL_TRANSFER;
      case "interbank": return INTERBANK_TRANSFER;
      default: return null;
    }
  }
}

package demo.app.bank.payment.vo;

public record BankAccountVO(
        String identificationNumber,
        String name,
        String currencyCode
) {
  public static BankAccountVO of(
          String identificationNumber,
          String name,
          String currencyCode) {
    return new BankAccountVO(identificationNumber, name, currencyCode);
  }
}

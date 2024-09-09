package demo.app.bank.payment.vo;

public record BeneficiaryVO(
   BankAccountVO bankAccount,
   String name
) {
  public static BeneficiaryVO of(BankAccountVO bankAccount,
                                 String name) {
    return new BeneficiaryVO(bankAccount, name);
  }
}

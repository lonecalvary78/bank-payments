package demo.app.bank.payment.domain;

import demo.app.bank.payment.model.FundTransferRequest;

public interface PaymentGroupSpecificTransferService {
  public void submitAndProcess(FundTransferRequest fundTransferRequest);
}

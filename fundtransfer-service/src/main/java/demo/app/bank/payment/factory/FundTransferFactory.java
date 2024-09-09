package demo.app.bank.payment.factory;

import demo.app.bank.payment.domain.PaymentGroupSpecificTransferService;
import demo.app.bank.payment.domain.constant.PaymentGroup;
import demo.app.bank.payment.domain.interbank.InterbankTransferService;
import demo.app.bank.payment.domain.internal.InternalTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FundTransferFactory {
  private final InternalTransferService internalTransferService;
  private final InterbankTransferService interbankTransferService;

  @Autowired
  public FundTransferFactory(InternalTransferService internalTransferService,
                             InterbankTransferService interbankTransferService) {
    this.internalTransferService = internalTransferService;
    this.interbankTransferService = interbankTransferService;
  }

  public PaymentGroupSpecificTransferService lookup(String paymentGroupCode) {
    switch (PaymentGroup.of(paymentGroupCode)) {
      case INTERNAL_TRANSFER: return internalTransferService;
      case INTERBANK_TRANSFER: return interbankTransferService;
      default: return null;
    }
  }
}

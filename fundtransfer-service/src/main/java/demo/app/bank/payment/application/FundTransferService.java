package demo.app.bank.payment.application;

import demo.app.bank.payment.domain.FundTransferRepository;
import demo.app.bank.payment.domain.constant.PaymentStatus;
import demo.app.bank.payment.factory.FundTransferFactory;
import demo.app.bank.payment.mapper.FundTransferMapper;
import demo.app.bank.payment.model.FundTransferRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundTransferService {
  private final FundTransferFactory fundTransferFactory;

  @Autowired
  public FundTransferService(FundTransferFactory fundTransferFactory) {
    this.fundTransferFactory = fundTransferFactory;
  }

  public void submitAndProcess(FundTransferRequest fundTransferRequest) {
    var fundTransferService = fundTransferFactory.lookup(fundTransferRequest.paymentGroup());
    fundTransferService.submitAndProcess(fundTransferRequest);
  }
}

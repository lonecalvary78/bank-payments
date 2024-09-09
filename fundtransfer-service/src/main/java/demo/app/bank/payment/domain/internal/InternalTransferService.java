package demo.app.bank.payment.domain.internal;

import demo.app.bank.payment.domain.FundTransfer;
import demo.app.bank.payment.domain.FundTransferRepository;
import demo.app.bank.payment.domain.PaymentGroupSpecificTransferService;
import demo.app.bank.payment.mapper.FundTransferMapper;
import demo.app.bank.payment.model.FundTransferRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class InternalTransferService implements PaymentGroupSpecificTransferService {
  private final FundTransferRepository fundTransferRepository;

  @Autowired
  public InternalTransferService(FundTransferRepository fundTransferRepository) {
    this.fundTransferRepository = fundTransferRepository;
  }

  @Transactional
  @Override
  public void submitAndProcess(FundTransferRequest fundTransferRequest) {
    var internalTransfer = FundTransferMapper.INSTANCE.fromRequest(fundTransferRequest);
    saveNew(internalTransfer);
  }

  private void saveNew(FundTransfer fundTransfer) {
    fundTransferRepository.save(fundTransfer);
  }
}

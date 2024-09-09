package demo.app.bank.payment.ui;

import demo.app.bank.payment.application.FundTransferService;
import demo.app.bank.payment.model.FundTransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fund-transfers")
public class FundTransferController {
  private final FundTransferService fundTransferService;

  @Autowired
  public FundTransferController(FundTransferService fundTransferService) {
    this.fundTransferService = fundTransferService;
  }

  public void submitAndProcess(@RequestBody FundTransferRequest fundTransferRequest) {
    fundTransferService.submitAndProcess(fundTransferRequest);
  }
}

package demo.app.bank.payment.charge.controller;

import demo.app.bank.payment.charge.domain.Charge;
import demo.app.bank.payment.charge.exception.NoSuchChargeException;
import demo.app.bank.payment.charge.model.dto.ChargeDTO;
import demo.app.bank.payment.charge.service.ChargeInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/view/charges/")
public class ChargeInquiryController {
  private final ChargeInquiryService chargeInquiryService;

  @Autowired
  public ChargeInquiryController(ChargeInquiryService chargeInquiryService) {
    this.chargeInquiryService = chargeInquiryService;
  }

  @GetMapping
  public List<ChargeDTO> findChargesFor(@RequestParam(value = "paymentGroup",required = true) String paymentGroup) {
    return chargeInquiryService.findChargesFor(paymentGroup);
  }

  @GetMapping
  public ChargeDTO viewCharge(Long chargeId) throws NoSuchChargeException {
    return chargeInquiryService.viewCharge(chargeId);
  }
}

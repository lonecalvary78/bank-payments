package demo.app.bank.payment.charge.controller;

import demo.app.bank.payment.charge.exception.DuplicateChargeEntryException;
import demo.app.bank.payment.charge.exception.NoSuchChargeException;
import demo.app.bank.payment.charge.model.dto.ChargeDTO;
import demo.app.bank.payment.charge.service.ChargeSetupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/charges")
public class ChargeSetupController {
  private final ChargeSetupService chargeSetupService;

  @Autowired
  public ChargeSetupController(ChargeSetupService chargeSetupService) {
    this.chargeSetupService = chargeSetupService;
  }

  @GetMapping
  public Page<ChargeDTO> getAllCharges(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
    return chargeSetupService.getAllCharges(PageRequest.of(currentPage,10));
  }

  @GetMapping("/{chargeId}")
  public ChargeDTO viewCharge(@PathVariable("chargeId") Long chargeId) throws NoSuchChargeException {
    return chargeSetupService.viewCharge(chargeId);
  }

  @PostMapping
  public void newCharge(@RequestBody @Valid ChargeDTO chargeDTO) throws DuplicateChargeEntryException {
    chargeSetupService.newCharge(chargeDTO);
  }

  @PutMapping("/{chargeId}")
  public void updateCharge(@PathVariable("chargeId") Long chargeId, @RequestBody @Valid ChargeDTO modfiedChargeDTO) throws NoSuchChargeException {
    chargeSetupService.updateCharge(chargeId, modfiedChargeDTO);
  }

  @DeleteMapping("/chargeId")
  public void removeCharge(@PathVariable("chargeId") Long chargeId) throws NoSuchChargeException {
    chargeSetupService.removeCharge(chargeId);
  }
}

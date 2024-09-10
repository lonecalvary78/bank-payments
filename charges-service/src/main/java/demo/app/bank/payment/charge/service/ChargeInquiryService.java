package demo.app.bank.payment.charge.service;

import demo.app.bank.payment.charge.domain.ChargeRepository;
import demo.app.bank.payment.charge.exception.NoSuchChargeException;
import demo.app.bank.payment.charge.mapper.ChargeMapper;
import demo.app.bank.payment.charge.model.dto.ChargeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChargeInquiryService {
  private final ChargeRepository chargeRepository;

  @Autowired
  public ChargeInquiryService(ChargeRepository chargeRepository) {
    this.chargeRepository = chargeRepository;
  }

  @Transactional(readOnly = true)
  public List<ChargeDTO> findChargesFor(String paymentGroup) {
    return chargeRepository.findChargesFor(paymentGroup).stream().map(charge -> ChargeMapper.INSTANCE.fromEntity(charge)).toList();
  }

  @Transactional(readOnly = true)
  public ChargeDTO viewCharge(Long chargeId) throws NoSuchChargeException {
    return chargeRepository.findById(chargeId).map(charge -> ChargeMapper.INSTANCE.fromEntity(charge)).orElseThrow(NoSuchChargeException::new);
  }
}

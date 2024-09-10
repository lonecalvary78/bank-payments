package demo.app.bank.payment.charge.service;

import demo.app.bank.payment.charge.domain.ChargeRepository;
import demo.app.bank.payment.charge.exception.DuplicateChargeEntryException;
import demo.app.bank.payment.charge.exception.NoSuchChargeException;
import demo.app.bank.payment.charge.mapper.ChargeMapper;
import demo.app.bank.payment.charge.model.dto.ChargeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChargeSetupService {
  private final ChargeRepository chargeRepository;

  @Autowired
  public ChargeSetupService(ChargeRepository chargeRepository) {
    this.chargeRepository = chargeRepository;
  }

  @Transactional(readOnly = true)
  public Page<ChargeDTO> getAllCharges(Pageable pageable) {
    return chargeRepository.findAll(pageable).map(charge-> ChargeMapper.INSTANCE.fromEntity(charge));
  }

  @Transactional(readOnly = true)
  public ChargeDTO viewCharge(Long chargeId) throws NoSuchChargeException {
    return chargeRepository.findById(chargeId).map(charge -> ChargeMapper.INSTANCE.fromEntity(charge)).orElseThrow(NoSuchChargeException::new);
  }

  @Transactional
  public void newCharge(ChargeDTO chargeDTO) throws DuplicateChargeEntryException {
    var charge = ChargeMapper.INSTANCE.fromDTO(chargeDTO);
    if(isChargeRecordedBefore(charge.getName(), charge.getChargeType(), charge.getPaymentGroup())) {
      throw new DuplicateChargeEntryException();
    }
    chargeRepository.save(charge);
  }

  @Transactional
  public void updateCharge(Long chargeId, ChargeDTO modfiedChargeDTO) throws NoSuchChargeException {
    var updateCharge = chargeRepository.findById(chargeId).map(charge -> charge.mergeWith(ChargeMapper.INSTANCE.fromDTO(modfiedChargeDTO))).orElseThrow(NoSuchChargeException::new);
    chargeRepository.save(updateCharge);
  }

  @Transactional
  public void removeCharge(Long chargeId) throws NoSuchChargeException {
    var charge = chargeRepository.findById(chargeId).orElseThrow(NoSuchChargeException::new);
    chargeRepository.delete(charge);
  }

  private boolean isChargeRecordedBefore(String chargeName, String chargeType, String paymentGroup) {
    return chargeRepository.countChargeForDuplicateEntryCheck(chargeName, chargeType, paymentGroup).longValue() > 0;
  }
}

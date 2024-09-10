package demo.app.bank.payment.charge.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long> {
  @Query("SELECT charge FROM Charge charge WHERE charge.paymentGroup=:paymentGroup")
  List<Charge> findChargesFor(@Param("paymentGroup") String paymentGroup);

  @Query("SELECT COUNT(charge) FROM Charge charge WHERE charge.name=:name AND charge.chargeType=:chargeType AND charge.paymentGroup=:paymentGroup")
  Long countChargeForDuplicateEntryCheck(@Param("name") String name, @Param("chargeType") String chargeType, @Param("paymentGroup") String paymentGroup);
}

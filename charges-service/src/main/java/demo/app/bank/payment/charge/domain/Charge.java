package demo.app.bank.payment.charge.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(uniqueConstraints = {
   @UniqueConstraint(name="uk_charge_1",columnNames = {"name","chargeType","payment_group"})
})
@NoArgsConstructor
@Getter
@Setter
public class Charge {
  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String name;

  private String description;

  @Column(name="charge_type", nullable = false)
  private String chargeType;

  @Column(name="payment_group", nullable = false)
  private String paymentGroup;

  @Column(name="currency_code", nullable = false)
  private String currencyCode;

  @Column(nullable = false)
  private BigDecimal amount;

  @Version
  private Long version;

  public Charge mergeWith(Charge modifiedCharge) {
    if (getChargeType().compareTo(modifiedCharge.getChargeType()) != 0) {
      setChargeType(modifiedCharge.getChargeType());
    }
    if (getPaymentGroup().compareTo(modifiedCharge.getPaymentGroup()) != 0) {
      setPaymentGroup(modifiedCharge.getPaymentGroup());
    }
    if (getDescription().compareTo(modifiedCharge.getDescription()) != 0) {
      setDescription(modifiedCharge.getDescription());
    }
    if (getAmount().compareTo(modifiedCharge.getAmount()) != 0) {
      setAmount(modifiedCharge.getAmount());
    }
    return this;
  }
}

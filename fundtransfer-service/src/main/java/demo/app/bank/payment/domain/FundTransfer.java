package demo.app.bank.payment.domain;

import demo.app.bank.payment.domain.constant.PaymentStatus;
import demo.app.bank.payment.vo.BankAccountVO;
import demo.app.bank.payment.vo.BeneficiaryVO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class FundTransfer {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "payment_date", nullable = false)
  private LocalDate paymentDate;

  @Column(name = "payment_group", nullable = false)
  private String paymentGroup;

  @Column(name="debit_account", nullable = false)
  @JdbcTypeCode(SqlTypes.JSON)
  private BankAccountVO debitAccount;

  @Column(nullable = false)
  @JdbcTypeCode(SqlTypes.JSON)
  private BeneficiaryVO beneficiary;

  @Column(name="payment_reference")
  private String paymentReference;

  @Column(name="currency_code", nullable = false)
  private String currencyCode;

  @Column(nullable = false)
  private BigDecimal amount;

  @Enumerated(EnumType.ORDINAL)
  private PaymentStatus status;
}

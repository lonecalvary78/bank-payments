package demo.app.bank.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import demo.app.bank.payment.vo.BankAccountVO;
import demo.app.bank.payment.vo.BeneficiaryVO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FundTransferRequest(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate paymentDate,
        String paymentGroup,
        BankAccountVO bankAccount,
        BeneficiaryVO beneficiary,
        String paymentReference,
        String currencyCode,
        BigDecimal amount) {
}

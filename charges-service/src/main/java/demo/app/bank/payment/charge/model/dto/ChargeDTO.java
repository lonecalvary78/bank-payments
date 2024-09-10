package demo.app.bank.payment.charge.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record ChargeDTO(
        Long id,
        String name,
        String description,
        String chargeType,
        String paymentGroup,
        String currencyCode,
        BigDecimal amount) {
}

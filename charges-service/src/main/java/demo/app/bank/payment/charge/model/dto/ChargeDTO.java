package demo.app.bank.payment.charge.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record ChargeDTO(
        Long id,
        @NotBlank(message = "charge name should not be empty")
        String name,
        String description,

        @NotBlank(message = "charge type should not be empty")
        String chargeType,

        @NotBlank(message = "payment group should not be empty")
        String paymentGroup,

        @NotBlank(message = "currency code should not be empty")
        String currencyCode,

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        @NotNull(message = "charge amount should be filled")
        BigDecimal amount) {
}

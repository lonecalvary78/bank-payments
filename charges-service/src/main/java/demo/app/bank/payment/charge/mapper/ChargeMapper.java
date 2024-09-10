package demo.app.bank.payment.charge.mapper;

import demo.app.bank.payment.charge.domain.Charge;
import demo.app.bank.payment.charge.model.dto.ChargeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChargeMapper {
  ChargeMapper INSTANCE = Mappers.getMapper(ChargeMapper.class);

  @Mappings({
      @Mapping(source = "id", target = "id"),
          @Mapping(source = "name", target = "name"),
          @Mapping(source = "description", target = "description"),
          @Mapping(source = "chargeType", target = "chargeType"),
          @Mapping(source = "paymentGroup", target = "paymentGroup"),
          @Mapping(source = "currencyCode", target = "currencyCode"),
          @Mapping(source = "amount", target = "amount"),

  })
  Charge fromDTO(ChargeDTO chargeDTO);

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "name", target = "name"),
          @Mapping(source = "description", target = "description"),
          @Mapping(source = "chargeType", target = "chargeType"),
          @Mapping(source = "paymentGroup", target = "paymentGroup"),
          @Mapping(source = "currencyCode", target = "currencyCode"),
          @Mapping(source = "amount", target = "amount"),

  })
  ChargeDTO fromEntity(Charge charge);
}

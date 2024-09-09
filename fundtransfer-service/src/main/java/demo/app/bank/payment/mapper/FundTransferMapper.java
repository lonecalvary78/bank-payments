package demo.app.bank.payment.mapper;

import demo.app.bank.payment.domain.FundTransfer;
import demo.app.bank.payment.model.FundTransferRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FundTransferMapper {
  FundTransferMapper INSTANCE = Mappers.getMapper(FundTransferMapper.class);

  @Mappings({
    @Mapping(source="paymentDate", target = "paymentDate"),
    @Mapping(source="paymentGroup", target = "paymentGroup"),
    @Mapping(source="paymentDate", target = "bankAccount"),
    @Mapping(source="paymentDate", target = "beneficiary"),
    @Mapping(source="paymentReference", target = "paymentReference"),
    @Mapping(source="currencyCode", target = "currencyCode"),
    @Mapping(source="amount", target = "amount")
  })
  public FundTransfer fromRequest(FundTransferRequest fundTransferRequest);
}

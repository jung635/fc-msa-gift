package dev.practice.gift.domain.gift;

import dev.practice.gift.domain.gift.order.OrderApiCommand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface GiftToOrderMapper {
    OrderApiCommand.RegisterOrderApiRequest of(GiftCommand.RegisterGiftRequest request);
    OrderApiCommand.RegisterOrderItem of(GiftCommand.RegisterOrderItem request);
    OrderApiCommand.RegisterOrderItemOptionGroup of(GiftCommand.RegisterOrderItemOptionGroup request);
    OrderApiCommand.RegisterOrderItemOption of(GiftCommand.RegisterOrderItemOption register);
}

package dev.practice.gift.domain.gift.order;

public interface OrderApiCaller {
    String registerOrder(OrderApiCommand.RegisterOrderApiRequest request);
}

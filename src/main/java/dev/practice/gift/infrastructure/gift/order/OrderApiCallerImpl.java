package dev.practice.gift.infrastructure.gift.order;

import dev.practice.gift.domain.gift.order.OrderApiCaller;
import dev.practice.gift.domain.gift.order.OrderApiCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderApiCallerImpl implements OrderApiCaller {
    @Override
    public String registerOrder(OrderApiCommand.RegisterOrderApiRequest request) {
        log.info("registerOrder execute");
        return null;
    }
}

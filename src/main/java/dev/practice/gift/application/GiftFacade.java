package dev.practice.gift.application;

import dev.practice.gift.domain.gift.GiftCommand;
import dev.practice.gift.domain.gift.GiftInfo;
import dev.practice.gift.domain.gift.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GiftFacade {
    private final GiftService giftService;

    public GiftInfo getOrder(String giftToken) {
        log.info("getOrder giftToken = {}", giftToken);
        return giftService.getGiftInfo(giftToken);
    }

    public GiftInfo registerGiftOrder(GiftCommand.RegisterGiftRequest command) {
        GiftInfo giftInfo = giftService.registerGiftOrder(command);
        log.info("registerGiftOrder orderToken = {}", giftInfo.getOrderToken());
        return giftInfo;
    }

    public void requestPaymentProcessing(String giftToken) {
        giftService.requestPaymentProcessing(giftToken);
    }

    public void completePayment(String orderToken) {
        giftService.completePayment(orderToken);
    }
}

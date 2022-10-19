package dev.practice.gift.domain.gift;

public interface GiftService {
    GiftInfo registerGiftOrder(GiftCommand.RegisterGiftRequest request);

    GiftInfo getGiftInfo(String giftToken);

    void requestPaymentProcessing(String giftToken);

    void completePayment(String orderToken);

}

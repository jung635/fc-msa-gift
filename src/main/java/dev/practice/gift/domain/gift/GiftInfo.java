package dev.practice.gift.domain.gift;

import lombok.Getter;

@Getter
public class GiftInfo {
    private final String orderToken;
    private final String giftToken;
    private final Gift.PushType pushType;
    private final String giftReceiverName;
    private final String giftReceiverPhone;
    private final String giftMessage;

    public GiftInfo(Gift gift) {
        this.orderToken = gift.getOrderToken();
        this.giftToken = gift.getGiftToken();
        this.pushType = gift.getPushType();
        this.giftReceiverName = gift.getGiftReceiverName();
        this.giftReceiverPhone = gift.getGiftReceiverPhone();
        this.giftMessage = gift.getGiftMessage();
    }
}

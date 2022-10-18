package dev.practice.gift.domain.gift;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class GiftCommand {

    @Builder
    @Getter
    public static class RegisterGiftRequest {
        private final Long buyerUserId;
        private final String payMethod;
        private final String pushType;
        private final String giftReceiverName;
        private final String giftReceiverPhone;
        private final String giftMessage;
        private final List<RegisterOrderItem> orderItemList;

        public Gift toEntity(String orderToken) {
            return Gift.builder()
                    .buyerUserId(buyerUserId)
                    .orderToken(orderToken)
                    .pushType(Gift.PushType.valueOf(pushType))
                    .giftReceiverName(giftReceiverName)
                    .giftReceiverPhone(giftReceiverPhone)
                    .giftMessage(giftMessage)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegisterOrderItem {
        private final String orderCount;
        private final String itemToken;
        private final String itemName;
        private final String itemPrice;
        private final List<RegisterOrderItemOptionGroup> orderItemOptionGroupList;
    }

    @Builder
    @Getter
    public static class RegisterOrderItemOptionGroup {
        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<RegisterOrderItemOption> orderItemOptionList;
    }

    @Builder
    @Getter
    public static class RegisterOrderItemOption {
        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;
    }
}

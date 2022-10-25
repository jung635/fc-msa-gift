package dev.practice.gift.interfaces.api.message;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GiftPaymentCompleteMessage {
    private String orderToken;
}
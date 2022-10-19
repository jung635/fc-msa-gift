package dev.practice.gift.domain.gift;

public interface GiftReader {
    Gift getGiftByGiftToken(String giftToken);
    Gift getGiftByOrderToken(String orderToken);
}

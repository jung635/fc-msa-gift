package dev.practice.gift.domain.gift;

public interface GiftService {
    GiftInfo registerGiftOrder(GiftCommand.RegisterGiftRequest request);
}

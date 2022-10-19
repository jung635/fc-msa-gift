package dev.practice.gift.infrastructure.gift;

import dev.practice.gift.domain.gift.Gift;
import dev.practice.gift.domain.gift.GiftReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GiftReaderImpl implements GiftReader {
    private final GiftRepository giftRepository;
    @Override
    public Gift getGiftByGiftToken(String giftToken) {
        return giftRepository.findByGiftToken(giftToken);
    }

    @Override
    public Gift getGiftByOrderToken(String orderToken) {
        return giftRepository.findByOrderToken(orderToken);
    }
}

package dev.practice.gift.domain.gift;

import dev.practice.gift.domain.gift.order.OrderApiCaller;
import dev.practice.gift.domain.gift.order.OrderApiCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService{
    private final GiftStore giftStore;
    private final OrderApiCaller orderApiCaller;
    private final GiftToOrderMapper giftToOrderMapper;
    @Override
    public GiftInfo registerGiftOrder(GiftCommand.RegisterGiftRequest request) {
        //상품 주문 API mapping
        OrderApiCommand.RegisterOrderApiRequest orderApiCommand = giftToOrderMapper.of(request);
        //상품 주문 API 실행 -> orderToken 리턴
        String orderToken = orderApiCaller.registerOrder(orderApiCommand);
        //OrderToken으로 Gift Entity 생성
        Gift initGift = request.toEntity(orderToken);
        //gift 저장
        Gift gift = giftStore.store(initGift);
        return new GiftInfo(gift);
    }
}

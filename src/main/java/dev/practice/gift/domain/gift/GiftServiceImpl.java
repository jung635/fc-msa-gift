package dev.practice.gift.domain.gift;

import dev.practice.gift.domain.gift.order.OrderApiCaller;
import dev.practice.gift.domain.gift.order.OrderApiCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService{
    private final GiftStore giftStore;
    private final OrderApiCaller orderApiCaller;
    private final GiftToOrderMapper giftToOrderMapper;

    private final GiftReader giftReader;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public GiftInfo getGiftInfo(String giftToken) {
        Gift gift = giftReader.getGiftByGiftToken(giftToken);
        return new GiftInfo(gift);
    }

    @Override
    @Transactional
    public void requestPaymentProcessing(String giftToken) {
        //Gift 객체 생성
        Gift gift = giftReader.getGiftByGiftToken(giftToken);
        //결제 상태 변경
        gift.inPayment();
    }

    @Override
    @Transactional
    public void completePayment(String orderToken) {
        //Gift 객체 생성
        Gift gift = giftReader.getGiftByOrderToken(orderToken);
        //결제 상태 변경
        gift.completePayment();
        //푸시
        gift.pushLink();
    }

    @Override
    @Transactional
    public void acceptGift(GiftCommand.Accept request) {
        //Gift 객체 생성
        Gift gift = giftReader.getGiftByGiftToken(request.getGiftToken());
        //주소 데이터 객체에 입력
        gift.accept(request);
        //주소 입력 API 실행
        orderApiCaller.updateReceiverInfo(gift.getOrderToken(), request);
    }
}

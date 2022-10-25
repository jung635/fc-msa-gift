package dev.practice.gift.interfaces.api.message;

import dev.practice.gift.application.GiftFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GiftKafkaMessageListener {
    private final String TOPIC_NAME = "fc.msa.order-payComplete-live.fifo";
    private final GiftFacade giftFacade;

    @KafkaListener(topics = {TOPIC_NAME}, containerFactory = "kafkaListenerContainerFactory")
    public void readMessage(GiftPaymentCompleteMessage message, Acknowledgment acknowledgment){
        log.info("[GiftKafkaMessageListener.readMessage] message = {}", message);
        var orderToken = message.getOrderToken();
        log.info("[GiftKafkaMessageListener.readMessage] orderToken = {}", orderToken);
        try{
            giftFacade.completePayment(orderToken);
            acknowledgment.acknowledge();
        }catch (Exception e) {
            log.error("[GiftKafkaMessageListener.readMessage] ERROR: {}", e.getMessage());
        }

    }

}

package br.live.com.kafkapc.producer;

import br.live.com.kafkapc.controller.EcommerceNewOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EcommerceNewOrderProducer {

    private final String topic;
    private final KafkaTemplate<String, EcommerceNewOrderDTO> kafkaTemplate;

    public EcommerceNewOrderProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, EcommerceNewOrderDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(EcommerceNewOrderDTO ecommerceNewOrderDTO){
        kafkaTemplate.send(topic, ecommerceNewOrderDTO).addCallback(
                success -> log.info("Messagem send" + success.getProducerRecord().value()),
                failure -> log.info("Message failure" + failure.getMessage())
        );
    }

}

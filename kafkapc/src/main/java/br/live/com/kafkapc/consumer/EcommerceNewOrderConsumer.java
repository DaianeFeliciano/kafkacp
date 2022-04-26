package br.live.com.kafkapc.consumer;

import br.live.com.kafkapc.controller.EcommerceNewOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EcommerceNewOrderConsumer {

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "ecommerceNewOrderKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, EcommerceNewOrderDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }

}


package dev.luanfernandes.consumer.service;


import dev.luanfernandes.consumer.record$.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ConsumerImpl implements Consumer {
    @KafkaListener(topics = {"car-api-log"})
    @Override
    public void consume(ConsumerRecord<String, Log> rec) {
        log.info("Consumed message -> {} | topic {}, partition {}", rec.value(),rec.topic(),rec.partition());
    }
}
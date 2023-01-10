package dev.luanfernandes.consumer.service;


import dev.luanfernandes.consumer.record$.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface Consumer {
    void consume(ConsumerRecord<String, Log> rec);
}

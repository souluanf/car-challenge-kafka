//package dev.luanfernandes.cars.infrastructure.implementation;
//
//
//import dev.luanfernandes.cars.core.kafka.KafkaConfig;
//import dev.luanfernandes.cars.core.kafka.TopicProperties;
//import dev.luanfernandes.cars.domain.listener.KafkaQueueService;
//import dev.luanfernandes.cars.domain.listener.event.RequestEncerradaEvent;
//import dev.luanfernandes.cars.domain.record$.Log;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class KafkaQueueServiceImpl implements KafkaQueueService {
//    private final TopicProperties topicProperties;
//    private final KafkaConfig kafkaConfig;
//    public KafkaQueueServiceImpl(TopicProperties topicProperties, KafkaConfig kafkaConfig) {
//        this.topicProperties = topicProperties;
//        this.kafkaConfig = kafkaConfig;
//    }
//    @EventListener
//    @Override
//    public void votacaoEncerradaListener(RequestEncerradaEvent event) {
//        log.info("Votação: {}.", event.getLog());
//        send(event.getLog());
//    }
//    @Override
//    public void send(Log log) {
//        kafkaConfig.kafkaTemplate().send(topicProperties.getName(),log);
//    }
//}

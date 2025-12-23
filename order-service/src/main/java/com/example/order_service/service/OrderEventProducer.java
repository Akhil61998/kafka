package com.example.order_service.service;

import com.example.order_service.dto.OrderCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class OrderEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public OrderEventProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void produce(OrderCreatedEvent event) {
        String json = objectMapper.writeValueAsString(event);
        kafkaTemplate.send("order-events", event.getOrderId(), json);

    }

}

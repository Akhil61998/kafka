package com.example.payment_consumer.service;

import com.example.payment_consumer.dto.OrderCreatedEvent;
import com.example.payment_consumer.entity.Payment;
import com.example.payment_consumer.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class
PaymentConsumer {

    private final PaymentRepository paymentRepository;

    @KafkaListener(topics = "order-events",groupId = "payment-group")
    public void receivePayment(String message) {

        System.out.println("Received Payment: " + message);

        try {
            ObjectMapper mapper = new ObjectMapper();
            OrderCreatedEvent event=
                    mapper.readValue(message, OrderCreatedEvent.class);

        Payment payment = new Payment();
        payment.setId(UUID.randomUUID().toString());
        payment.setOrderId(event.getOrderId());
        payment.setAmount(event.getAmount());
        payment.setStatus("SUCCESS");


        paymentRepository.save(payment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}

package com.example.order_service.service;


import com.example.order_service.dto.CreateOrderRequest;
import com.example.order_service.dto.OrderCreatedEvent;
import com.example.order_service.entity.Order;
import com.example.order_service.reposirory.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private  final OrderEventProducer orderEventProducer;

    OrderService(OrderRepository orderRepository, OrderEventProducer orderEventProducer) {
        this.orderRepository = orderRepository;
        this.orderEventProducer = orderEventProducer;
    }

    public String createdOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setUserId(request.getUserId());
        order.setAmount(request.getAmount());
        order.setStatus("Created");
        order.setCreatedAt(LocalDateTime.now());

        orderRepository.save(order);


        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(

                order.getId(),
                order.getUserId(),
                order.getAmount(),
                LocalDateTime.now()

        );

        orderEventProducer.produce(orderCreatedEvent);

        return "Order Created with id: "+order.getId();

    }

}

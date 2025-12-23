package com.example.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class OrderCreatedEvent {

    private String orderId;
    private String userId;
    private BigDecimal amount;
   private LocalDateTime createdAt;
}

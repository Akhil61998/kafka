package com.example.payment_consumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="payments")
@Data
public class Payment {

    @Id
    private String id;

    private String orderId;
    private BigDecimal amount;
    private String status;



}

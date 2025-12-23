package com.example.order_service.controller;


import com.example.order_service.dto.CreateOrderRequest;
import com.example.order_service.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {


    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String>  creteOrder(@RequestBody CreateOrderRequest request){

        String orderId=orderService.createdOrder(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderId);

    }


}

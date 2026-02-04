package com.ordermanagement.kafka_cloud_functions_streams_producer.controller;

import com.ordermanagement.kafka_cloud_functions_streams_producer.dto.AccountDto;
import com.ordermanagement.kafka_cloud_functions_streams_producer.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto){

        String response = accountsService.createAccount(accountDto);

        return  ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}

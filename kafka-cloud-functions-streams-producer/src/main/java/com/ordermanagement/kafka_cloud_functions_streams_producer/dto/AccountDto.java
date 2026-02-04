package com.ordermanagement.kafka_cloud_functions_streams_producer.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long accountNumber;
    private String name;
    private String email;
    private String mobileNumber;

    private String accountType;


    private String branchAddress;

}

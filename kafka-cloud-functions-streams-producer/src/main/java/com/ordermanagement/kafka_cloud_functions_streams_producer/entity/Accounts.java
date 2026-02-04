package com.ordermanagement.kafka_cloud_functions_streams_producer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Accounts {

    @Column(name="account_number")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    String name;

    String email;

    String mobileNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name="branch_address")
    private String branchAddress;

    @Column(name = "communication_sw")
    private Boolean communicationSw;

}


package com.ordermanagement.kafka_cloud_functions_streams_message.dto;

public record AccountsMsgDto(Long accountNumber,String name,String email, String mobileNumber ) {
}

package com.ordermanagement.kafka_cloud_functions_streams_producer.functions;

import com.ordermanagement.kafka_cloud_functions_streams_producer.service.AccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountFunctions {
    private static final Logger log = LoggerFactory.getLogger(AccountFunctions.class);

    @Bean
    public Consumer<Long> updateCommunication(AccountsService accountsService){

        return accountNumber-> {
            log.info("Updating Communication status for the account number : " + accountNumber.toString());
          accountsService.updateCommunicationStatus(accountNumber);
        };

    }
}

package com.ordermanagement.kafka_cloud_functions_streams_producer.service;

import com.ordermanagement.kafka_cloud_functions_streams_producer.dto.AccountDto;
import com.ordermanagement.kafka_cloud_functions_streams_producer.dto.AccountsMsgDto;
import com.ordermanagement.kafka_cloud_functions_streams_producer.entity.Accounts;
import com.ordermanagement.kafka_cloud_functions_streams_producer.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountsService {
    private static final Logger log = LoggerFactory.getLogger(AccountsService.class);
    private final AccountsRepository accountsRepository;
    private final StreamBridge streamBridge;

    public String createAccount(AccountDto accountDto){

        Accounts accounts = new Accounts();

        accounts.setAccountType(accountDto.getAccountType());
        accounts.setEmail(accountDto.getEmail());
        accounts.setName(accountDto.getName());
        accounts.setBranchAddress(accountDto.getBranchAddress());
        accounts.setMobileNumber(accountDto.getMobileNumber());

        Accounts savedAccount = accountsRepository.save(accounts);

        sendCommunication(savedAccount);

        return "Account Details Saved Successfully";

    }

    public void sendCommunication(Accounts accounts){

        var accountsMsgDto= new AccountsMsgDto(accounts.getAccountNumber(), accounts.getName(),accounts.getEmail(),accounts.getMobileNumber());
        log.info("Sending Communication request for the details: {}", accountsMsgDto);
        var result = streamBridge.send("send-communication", accountsMsgDto);
        log.info("Is the Communication request successfully triggered ? : {}", result);

    }

    public boolean updateCommunicationStatus(Long accountNumber) {
        boolean isUpdated = false;
        if(accountNumber !=null ){
            Accounts accounts = accountsRepository.findById(accountNumber).orElseThrow(
                    () -> new ResourceNotFoundException(accountNumber.toString())
            );
            accounts.setCommunicationSw(true);
            accountsRepository.save(accounts);
            isUpdated = true;
        }
        return  isUpdated;
    }
}

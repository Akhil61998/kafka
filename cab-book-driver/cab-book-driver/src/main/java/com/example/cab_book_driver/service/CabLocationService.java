package com.example.cab_book_driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    public static final String CAB_LOCATION = "cab-location";

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    public boolean updateLocation(String location){

        kafkaTemplate.send(CAB_LOCATION , location);

        return  true;
    }

}

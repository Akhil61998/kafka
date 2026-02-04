package com.ordermanagement.kafka_cloud_functions_streams_producer.repository;

import com.ordermanagement.kafka_cloud_functions_streams_producer.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
}

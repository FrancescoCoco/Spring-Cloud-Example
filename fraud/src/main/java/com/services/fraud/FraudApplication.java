package com.services.fraud;

import com.services.fraud.Repositories.FraudCheckHistoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories(basePackageClasses = FraudCheckHistoryRepository.class)
public class FraudApplication {
    public static void main(String[]args){
        SpringApplication.run(FraudApplication.class,args);
    }
}

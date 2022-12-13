package com.services.fraud.Services;

import com.services.fraud.Models.FraudCheckHistory;
import com.services.fraud.Repositories.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudServices {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;


    public boolean IsFraudulentCustomer(Integer customerId){
        this.fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .localDateTime(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}

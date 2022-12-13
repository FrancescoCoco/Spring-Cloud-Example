package com.services.fraud.Controllers;

import com.services.fraud.Records.FraudCheckResponse;
import com.services.fraud.Services.FraudServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    @Autowired
    private final FraudServices fraudServices;

    @GetMapping(path="/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")Integer customerId){
          boolean isFraudulentCustomer= fraudServices.IsFraudulentCustomer(customerId);
          log.info("fraud check request for customer {} ", customerId);
          return new FraudCheckResponse(isFraudulentCustomer);
    }
}

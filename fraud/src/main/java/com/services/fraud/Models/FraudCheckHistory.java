package com.services.fraud.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("groceryitems")
public class FraudCheckHistory {
    @Id
    private BigInteger Id;

    private int customerId;
    private Boolean isFraudster;
    private LocalDateTime localDateTime;

}

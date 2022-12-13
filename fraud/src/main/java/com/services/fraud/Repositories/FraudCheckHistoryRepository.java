package com.services.fraud.Repositories;

import com.services.fraud.Models.FraudCheckHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository extends MongoRepository<FraudCheckHistory,Integer> {
}

package dev.tamasbakos.fraud.service;

import dev.tamasbakos.fraud.model.FraudCheckHistory;
import dev.tamasbakos.fraud.repository.FraudCheckHistoryRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FraudCheckService {

  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  public boolean isFraudulentCustomer(Integer customerId) {
    fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
        .customerId(customerId)
        .isFraudster(false)
        .createdAt(LocalDateTime.now())
        .build()
    );
    return false;
  }

}

package com.bootcamp.creditcard.repository;

import com.bootcamp.creditcard.model.CreditCardMovement;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CreditCardMovementRepository extends ReactiveCrudRepository<CreditCardMovement, String> {
    Flux<CreditCardMovement> findByCreditCardNumber(String num);
}

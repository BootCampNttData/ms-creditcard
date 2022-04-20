package com.bootcamp.creditcard.service.Impl;

import com.bootcamp.creditcard.model.CreditCardMovement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardMovementService {
    Flux<CreditCardMovement> findAll();
    Mono<CreditCardMovement> create(CreditCardMovement creditCardMovement);
    Flux<CreditCardMovement> findByCreditCardNumber(Integer num);
    Mono<CreditCardMovement> update(CreditCardMovement creditCardMovement);
    Mono<CreditCardMovement> deleteById(String id);
    Mono delete(CreditCardMovement creditCardMovement);
}

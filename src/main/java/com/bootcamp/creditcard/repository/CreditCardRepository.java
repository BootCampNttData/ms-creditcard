package com.bootcamp.creditcard.repository;

import com.bootcamp.creditcard.model.CreditCard;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CreditCardRepository extends ReactiveCrudRepository<CreditCard, String> {
    Flux<CreditCard> findByCreditCardNumber(String num);
    Flux<CreditCard> findByClientId(String clientId) ;
}

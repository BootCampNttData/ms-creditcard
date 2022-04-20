package com.bootcamp.creditcard.service.Impl;


import com.bootcamp.creditcard.model.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {
    Flux<CreditCard> findAll();
    Mono<CreditCard> create(CreditCard creditCard);
    Flux<CreditCard> findByCreditCardNumber(String num);
    Mono<CreditCard> update(CreditCard creditCard);
    Mono<CreditCard> deleteById(String id);
    Mono delete(CreditCard creditCard);
}

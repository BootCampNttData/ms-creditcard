package com.bootcamp.creditcard.service.Impl.impl;


import com.bootcamp.creditcard.model.CreditCard;
import com.bootcamp.creditcard.repository.CreditCardRepository;
import com.bootcamp.creditcard.service.Impl.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor

public class CreditCardServiceImpl implements CreditCardService {
    public final CreditCardRepository repository;

    @Override
    public Mono<CreditCard> create(CreditCard creditCard) {
        return repository.save(creditCard);
    }

    @Override
    public Mono<CreditCard> update(CreditCard creditCard) {
        return repository.save(creditCard);
    }

    @Override
    public Mono deleteById(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono delete(CreditCard creditCard) {
        return repository.delete(creditCard);
    }

    @Override
    public Flux<CreditCard> findAll() {
        return repository.findAll();
    }

    @Override
    public Flux<CreditCard> findByCreditCardNumber(String id) {
        return repository.findByCreditCardNumber(id);
    }
}
package com.bootcamp.creditcard.controller;

import com.bootcamp.creditcard.model.CreditCard;
import com.bootcamp.creditcard.service.Impl.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/creditCard")
@RequiredArgsConstructor
public class CreditCardController {
    public final CreditCardService service;
    @GetMapping
    public Flux<CreditCard> getAll(){
        return service.findAll();
    }

    @GetMapping("/find/{num}")
    public Flux<CreditCard> getByIdCreditCard(@PathVariable("num") String num){
        return service.findByCreditCardNumber(num);
    }

    @PostMapping
    public Mono<CreditCard> create(@RequestBody CreditCard creditCard){
        return service.create(creditCard);
    }

    @PostMapping("/update")
    public Mono<CreditCard> update(@RequestBody CreditCard creditCard){
        return service.create(creditCard);
    }

    @DeleteMapping
    public Mono<CreditCard> delete(@RequestBody CreditCard creditCard){
        return service.delete(creditCard);
    }

    @DeleteMapping("/byId/{id}")
    public Mono<CreditCard> deleteById(@RequestBody String id){
        return service.deleteById(id);
    }

}
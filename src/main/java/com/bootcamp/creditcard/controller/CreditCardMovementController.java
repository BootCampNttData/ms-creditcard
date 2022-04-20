package com.bootcamp.creditcard.controller;

import com.bootcamp.creditcard.model.CreditCardMovement;
import com.bootcamp.creditcard.service.Impl.CreditCardMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/creditCardMovement")
@RequiredArgsConstructor
public class CreditCardMovementController {
    @Value("${creditCardMovement.server.url}")
    private String actPrdUrl;

    public final CreditCardMovementService service;
    @GetMapping
    public Flux<CreditCardMovement> getAll(){
        return service.findAll();
    }

    @GetMapping("/find/{num}")
    public Flux<CreditCardMovement> getByIdCreditCard(@PathVariable("num") Integer num){
        return service.findByCreditCardNumber(num);
    }

    @PostMapping
    public Mono<CreditCardMovement> create(@RequestBody CreditCardMovement creditCardMovement){
        return service.create(creditCardMovement);
    }

    @PostMapping("/update")
    public Mono<CreditCardMovement> update(@RequestBody CreditCardMovement creditCardMovement){
        return service.create(creditCardMovement);
    }

    @DeleteMapping
    public Mono<CreditCardMovement> delete(@RequestBody CreditCardMovement creditCardMovement){
        return service.delete(creditCardMovement);
    }

    @DeleteMapping("/byId/{id}")
    public Mono<CreditCardMovement> deleteById(@RequestBody String id){
        return service.deleteById(id);
    }

    @GetMapping("/accountBalance/{account}")
    public String getAccountBalance(@PathVariable("account") String account){
        double balance=0;
        RestTemplate restTemplate=new RestTemplate();
        String urlDp = actPrdUrl +"/creditCardMovement/find/" + account;
        ResponseEntity<CreditCardMovement[]> creditCardMovements = restTemplate.getForEntity(urlDp,CreditCardMovement[].class);
        for(CreditCardMovement am: creditCardMovements.getBody()){
            if (am.getMovementType().equals("D")){
                balance += am.getAmount();
            }else{
                balance -= am.getAmount();
            }
        }
        return String.valueOf(balance);
    }
}
package com.bootcamp.creditcard.controller;

import com.bootcamp.creditcard.model.CreditCard;
import com.bootcamp.creditcard.model.CreditCardMovement;
import com.bootcamp.creditcard.service.Impl.CreditCardMovementService;
import com.bootcamp.creditcard.service.Impl.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/creditCard")
@RequiredArgsConstructor
public class CreditCardController {
    public final CreditCardService service;
    public final CreditCardMovementService creditCardMovementService;
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

/** *******************************************************************************************/
    @GetMapping("/movement")
    public Flux<CreditCardMovement> getAllMovements(){
        return creditCardMovementService.findAll();
    }

    @GetMapping("/movement/find/{num}")
    public Flux<CreditCardMovement> getByIdCreditCard(@PathVariable("num") Integer num){
        return creditCardMovementService.findByCreditCardNumber(num);
    }

    @PostMapping("/movement")
    public Mono<CreditCardMovement> create(@RequestBody CreditCardMovement creditCardMovement){
        return creditCardMovementService.create(creditCardMovement);
    }

    @PostMapping("/movement/update")
    public Mono<CreditCardMovement> update(@RequestBody CreditCardMovement creditCardMovement){
        return creditCardMovementService.create(creditCardMovement);
    }

    @DeleteMapping("/movement")
    public Mono<CreditCardMovement> delete(@RequestBody CreditCardMovement creditCardMovement){
        return creditCardMovementService.delete(creditCardMovement);
    }

    @DeleteMapping("/movement/byId/{id}")
    public Mono<CreditCardMovement> deleteMovementById(@PathVariable("id")  String id){
        return creditCardMovementService.deleteById(id);
    }

    @GetMapping("/accountBalance/{account}")
    public String getAccountBalance(@PathVariable("account") String account){
        double balance=0;
//        RestTemplate restTemplate=new RestTemplate();
//        String urlDp = actPrdUrl +"/creditCardMovement/find/" + account;
//        ResponseEntity<CreditCardMovement[]> creditCardMovements = restTemplate.getForEntity(urlDp,CreditCardMovement[].class);
//        for(CreditCardMovement am: creditCardMovements.getBody()){
//            if (am.getMovementType().equals("D")){
//                balance += am.getAmount();
//            }else{
//                balance -= am.getAmount();
//            }
//        }
        return String.valueOf(balance);
    }


}
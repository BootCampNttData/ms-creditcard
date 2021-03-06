package com.bootcamp.creditcard.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document

public class CreditCard {
    @Id
    private String id;
    private Integer creditCardNumber;
    private String clientId;
    private Date expeditionDate;
    private Date expirationDate;
    private Double creditLimit;
}

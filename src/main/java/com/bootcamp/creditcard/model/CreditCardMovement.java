package com.bootcamp.creditcard.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document

public class CreditCardMovement {
    @Id
    private String id;
    private Integer creditCardNumber;
    private String movementType;
    private Date movementDate;
    private Double amount;
    private Double creditLimit;
}

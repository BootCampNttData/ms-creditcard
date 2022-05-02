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
    private String creditCardNumber;
    private String movementType; /** [P]Pago | [C]Compra */
    private String movementDate;
    private Double amount;
    private Double creditLimit;

}

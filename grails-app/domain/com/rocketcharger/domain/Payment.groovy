package com.rocketcharger.domain.payment

class Payment {

    String name
    Customer customer
    Payer payer
    
     static constraints = {
        name size: 3..100, nulllable: true
        email size: 5..100, nulllable: true

    }
}
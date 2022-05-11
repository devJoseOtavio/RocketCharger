package com.rocketcharger.domain.payer

import com.rocketcharger.domain.customer.Customer

class Payer {

    String name

    String email

    String cpfCnpj

    String postalCode

    String address

    String district

    String city

    String state
    
    Customer customer

    static constraints = {
        name nulllable: false, blank: false
        email email: true, unique:true
        cpfCnpj validator: { valor, customer ->
            if(!valor.size() == 11 || 14)
            alert("erro ao validar CPF/CNPJ")
            return;
            }
        postalCode nulllable: false, blank: false
        address nulllable: false, blank: false
        district nulllable: false, blank: false
        city nulllable: false, blank: false
        state nulllable: false, blank: false
    }
}
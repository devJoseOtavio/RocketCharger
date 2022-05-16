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
        name blank: false 
        email unique: true, blank: false, nullable: false
        cpfCnpj blank: false
        postalCode blank: false
        address blank: false
        district blank: false
        city blank: false
        state blank: false
    }
}
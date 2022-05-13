package com.rocketcharger.domain.customer

class Customer {

    String name

    String email

    String cpfCnpj

    String postalCode

    String address

    String district

    String city
    
    String state
    
     static constraints = {
        name nulllable: false, blank: false 
        email unique: true, blank: false, nullable: false
        cpfCnpj nulllable: false, blank: false
        postalCode nulllable: false, blank: false
        address nulllable: false, blank: false
        district nulllable: false, blank: false
        city nulllable: false, blank: false
        state nulllable: false, blank: false
    }
}

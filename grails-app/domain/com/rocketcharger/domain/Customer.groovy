package com.rocketcharger.domain.customer

class Customer {

    String name

    String phone

    String email

    String cpfCnpj

    String postalCode

    String address

    String number

    String district

    String city
    
    String state
    
     static constraints = {
        name size: 3..100
        email size: 5..100
    }
}

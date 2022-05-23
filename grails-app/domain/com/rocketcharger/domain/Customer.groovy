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
        name blank: false 
        email unique: true, blank: false
        cpfCnpj blank: false
        postalCode blank: false
        address blank: false
        district blank: false
        city blank: false
        state blank: false
    }
}

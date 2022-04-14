package com.rocketcharger.domain

class Customer {

    String name
    String cpf
    String email
    String postalCode
    String adress
    String city
    String state

    static constraints = {
        nome size: 5..150
        email size: 5..120
    }
}

package com.rocketcharger.domain.customer
import com.rocketcharger.domain.payer.Payer

class Customer {

    String name
    String email
    String cpfCnpj
    String postalCode
    String address
    String province
    String city
    String state

    static hasMany = [payers: Payer]

    static constraints = {}
}

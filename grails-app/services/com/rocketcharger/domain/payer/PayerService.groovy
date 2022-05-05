package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer

class PayerService {
    def save(Map params) {
        Customer customer = Customer.get(params.int('customerId'))
        Payer payer = new Payer(params)
        payer.name = params.name
        payer.save(failOnError: true)
        return payer
    }
}

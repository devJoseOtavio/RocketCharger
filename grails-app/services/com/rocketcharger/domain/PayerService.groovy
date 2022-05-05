package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer

class PayerService {
    def save(Map params) {
        Payer payer = new Payer(params)
        payer.name = params.name
        payer.save(failOnError: true)
        return payer
    }
}
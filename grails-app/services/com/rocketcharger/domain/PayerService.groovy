package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    def save(Map params) {
        Customer customer = Customer.get(params.long("id"))
        Payer payer = new Payer(params)
        payer.save(failOnError: true)
        return payer
    }

    def index() {
        return Payer.getAll()
    }

    def update(Long id, Map params) {
        if (!id) {
            throw new Exception('Erro ao realizar edição')
            return
       }
        Payer payer = Payer.get(params.long("id"))
        payer.name = params.name
        payer.email = params.email
        payer.cpfCnpj = params.cpfCnpj
        payer.postalCode = params.postalCode
        payer.address = params.address
        payer.district = params.district
        payer.city = params.city
        payer.state = params.state
        payer.save(flush: true, failOnError: true)
    }
}
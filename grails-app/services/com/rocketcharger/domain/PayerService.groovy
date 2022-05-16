package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    def save(Map params) {
        println 'passo4'
        Customer customer = Customer.get(Long.valueOf("params.id"))
        Payer payer = new Payer(params)
        payer.save(failOnError: true)
        return payer;
    }

    def index() {
        return Payer.getAll()
    }

    def getPayer(Long id) {
        return Payer.get(id)
    }

    def update(Long id, Map params) {
        if (!params.id) {
            throw new Exception('Erro ao realizar edição')
            return;
       }
        Payer payer = Payer.get(Long.valueOf("params.id"))
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
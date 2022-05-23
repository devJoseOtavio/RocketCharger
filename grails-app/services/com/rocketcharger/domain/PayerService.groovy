package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public Payer save(Map params) {
        Customer customer = Customer.get(params.int("customerId"))
        Payer payer = new Payer(params)
        payer.save(failOnError: true)
        return payer
    }

    public List<Payer> list() {
        return Payer.getAll()
    }

    public Payer getPayer(Integer id) {
        return Payer.get(id)
    }

    public Payer update(Map params) {
        if (!params.id) return
        Payer payer = Payer.get(params.int("id"))
        payer.name = params.name
        payer.email = params.email
        payer.cpfCnpj = params.cpfCnpj
        payer.postalCode = params.postalCode
        payer.address = params.address
        payer.district = params.district
        payer.city = params.city
        payer.state = params.state
        payer.save(flush: true, failOnError: true)
        return payer
    }
}
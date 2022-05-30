package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.utils.DomainUtils
import com.rocketcharger.utils.ValidateUtils
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public Payer save(Map params) {
        Customer customer = Customer.get(params.int("customerId"))
        Payer payer = new Payer(params)
        ValidateUtils.emailIsValid(params.email)
        payer.save(failOnError: true)
        return payer
    }
    
    public List<Payer> index() {
        return Payer.getAll()
    }

    public Payer getPayer(Integer id) {
        return Payer.get(id)
    }

    public Payer update(Map params) {
        if (!params.id) DomainUtils.addError(payer, "Erro ao realizar edição")
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

    public Payer validate(Map params) {
        Payer payer = new Payer()
        if (!params.name) {
            DomainUtils.addError(payer, "")
        }
        if (!params.email) {
            DomainUtils.addError(payer, "")
        }
        if (!params.cpfCnpj) {
            DomainUtils.addError(payer, "")
        }
        if (!params.postalCode) {
            DomainUtils.addError(payer, "")
        }
        if (!params.address) {
            DomainUtils.addError(payer, "")
        }
        if (!params.district) {
            DomainUtils.addError(payer, "")
        }
        if (!params.city) {
            DomainUtils.addError(payer, "")
        }
        if (!params.state) {
            DomainUtils.addError(payer, "")
        }
        return payer
    }
}
package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public Payer save(Map params) {
        validate(params)
        Customer customer = Customer.get(params.int('customerId'))
        Payer payer = new Payer(params)
        payer.save(failOnError: true)
        return payer;
    }
    
    public List <Payer> index() {
        return Payer.getAll()
    }

    public Payer getPayer(Integer id) {
        return Payer.get(id)
    }

    public Payer update(Map params) {
        if (!params.id) throw new Exception('Erro ao realizar edição')
        validate(params)
        Payer payer = Payer.get(params.int('id'))
        payer.name = params.name
        payer.email = params.email
        payer.cpfCnpj = params.cpfCnpj
        payer.postalCode = params.postalCode
        payer.address = params.address
        payer.district = params.district
        payer.city = params.city
        payer.state = params.state
        payer.save(flush: true, failOnError: true)
        return payer;
    }

    private void validate(Map params){
        if (!params.name) {
            throw new Exception('Erro no registro do nome informado.')
        }
        if (!params.email) {
            throw new Exception('Erro no registro do email informado.')
        }
        if (!params.cpfCnpj) {
            throw new Exception('Erro na registro de CPF/CNPJ')
        }
        if (!params.postalCode) {
            throw new Exception('Erro no registro do CEP informado.')
        }
        if (!params.address) {
            throw new Exception('Erro no registro do endereço informado.')
        }
        if (!params.district) {
            throw new Exception('Erro no registro do bairro informado.')
        }
        if (!params.city) {
            throw new Exception('Erro no registro da cidade informada.')
        }
        if (!params.state) {
            throw new Exception('Erro no registro do Estado informada.')
        }
    }
}
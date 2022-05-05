package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer
import grails.gorm.transactions.Transactional 

@Transactional
class PayerService {

    def save(Map params) {
        Payer payer = new Payer(params)
        payer.save(failOnError: true)
       }

    def index() {
        return Payer.getAll()
    }
        
    def getPayer(Integer id){
         return Payer.get(id)
    }

    def update(Map params){
        if (!params.id) {
            throw new Exception("Erro ao realizar edição")
            return; 
       }
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
    }
}

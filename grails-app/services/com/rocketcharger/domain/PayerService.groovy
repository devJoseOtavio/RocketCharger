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
<<<<<<< HEAD
        return Payer.getAll()
=======
            return Payer.getAll()
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
    }
        
    def getPayer(Integer id){
         return Payer.get(id)
    }

    def update(Map params){
        if (params.id) {
            Payer payer = Payer.get(params.int("id"))
            payer.name = params.name
            payer.email = params.email
            payer.cpfCnpj = params.cpfCnpj
            payer.postalCode = params.postalCode
            payer.address = params.address
<<<<<<< HEAD
            payer.province = params.province
            payer.city = params.city
            payer.state = params.state
            payer.save(flush: true, failOnError: true)
=======
            payer.district = params.district
            payer.city = params.city
            payer.state = params.state
            payer.save(flush: true, failOnError: true)
            return payer
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
       } else {
            throw new Exception("Erro ao realizar edição")
       }
    }
}

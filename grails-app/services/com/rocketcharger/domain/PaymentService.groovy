package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import grails.gorm.transactions.Transactional 

@Transactional
class PaymentService {

    def save(Map params) {
         Payment payment = new Payment(params)
         payment.save(failOnError: true)
     }

    def index() {
        return Payment.getAll()
    }

    def getPayment(Integer id){
        return Payment.get(id)
    }

    def update(Map params){
        if (!params.id) {
        return;
    }   
        Payment payment = Payment.get(params.int("id"))
        payment.name = params.name
        payment.email = params.email
        payment.cpfCnpj = params.cpfCnpj
        payment.postalCode = params.postalCode
        payment.address = params.address
        payment.district = params.district
        payment.city = params.city
        payment.state = params.state
        payment.save(flush: true, failOnError: true)
    } 
}
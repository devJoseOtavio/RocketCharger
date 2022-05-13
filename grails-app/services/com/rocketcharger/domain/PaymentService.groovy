package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import grails.gorm.transactions.Transactional 

@Transactional
class PaymentService {

    def save(Map params) {
        // Customer customer = Customer.get(params.int('customerId'))
        // Payer payer = Payer.get(params.int('payerId'))
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
        payment.value = params.value
        payment.billingType = params.billingType
        payment.status = params.status
        payment.dueDate = params.dueDate
        payment.customer = params.customer
        payment.payer = params.payer
        payment.save(flush: true, failOnError: true)
    } 
}
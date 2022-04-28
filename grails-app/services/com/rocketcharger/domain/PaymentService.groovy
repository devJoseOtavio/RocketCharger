package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import grails.gorm.transactions.Transactional

@Transactional
class Payment {

    def save(Map params) {
        Payment payment = new Payment(params)
        payment.save(failOnError: true)
    }
    def index() {
        return Payment.getAll()
    }
    def getPayment(Integer id) {
        return Payment.get(id)
    }
    def update(Map params) {
        if (payment.id) {
            Payment payment = Payment.get(params.int('id'))
            payment.billingType = params.billingType
            payment.status = params.status
            payment.duedate = params.duedate
            payment.save(flush: true, failOnError: true)
            return payment
       } else {
            throw new Exception('Erro ao realizar edição')
        }
    }

}

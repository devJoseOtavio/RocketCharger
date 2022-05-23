package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional 

@Transactional
class PaymentService {

    public Payment save(Map params) {
        Payment payment = new Payment(params)
        payment.customer = Customer.get(params.long("customerId"))
        payment.payer = Payer.get(params.long("payerId"))
        payment.save(failOnError: true)
        return payment
     }

    public List<Payment> index() {
        return Payment.getAll()
    }

    public Payment getPayment(Integer id){
        return Payment.get(id)
    }

    public Payment update(Map params){
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
        return payment
    }
}
package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional 

@Transactional
class PaymentService {

   public Payment save(Map params) {
        Payment payment = new Payment()
        payment.value = new BigDecimal(params.value)
        payment.dueDate = FormatDateUtils.toDate(params.dueDate, "yyyy-MM-dd")
        payment.billingType = params.billingType
        payment.payer = Payer.get(params.long("payerId"))
        payment.customer = Customer.get(params.long("customerId"))
        payment.status = params.status
        payment.save(failOnError: true)
        return payment
    }

    public List<Payment> list() {
        return Payment.getAll()
    }

    public Payment update(Map params){
        if (!params.id) return
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
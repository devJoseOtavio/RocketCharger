package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.enums.PaymentMethod
import com.rocketcharger.enums.PaymentStatus

import grails.gorm.transactions.Transactional 

@Transactional
class PaymentService {

    public Payment save(Map params) {
        println params
        Payment payment = new Payment()
        payment.value = params.value
        payment.dueDate = FormatDateUtils.toDate(params.dueDate, "dd-MM-yyyy")
        payment.billingType = PaymentMethod.valueOf(params.method)
        payment.status = PaymentStatus.PENDING
        payment.customer = Customer.get(params.long("id"))
        payment.payer = Payer.get(params.long("id"))
        payment.save(failOnError: true)
        return payment
     }

    public List<Payment> index() {
        return Payment.getAll()
    }

    public Payment getPayment(Long id) {
        return Payment.get(id)
    }
}
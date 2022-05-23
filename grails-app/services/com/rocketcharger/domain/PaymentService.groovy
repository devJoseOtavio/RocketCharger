package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.enums.PaymentMethod
import com.rocketcharger.enums.PaymentStatus
import com.rocketcharger.utils.FormatDateUtils

import grails.gorm.transactions.Transactional 

@Transactional
class PaymentService {

    public Payment save(Map params) {
        Payment payment = new Payment()
        payment.value = new BigDecimal(params.value)
        payment.dueDate = FormatDateUtils.toDate(params.dueDate, "yyyy-MM-dd")
        payment.billingType = PaymentMethod.valueOf(params.billingType)
        payment.payer = Payer.get(params.long("payerId"))
        payment.customer = Customer.get(params.long("customerId"))
        payment.status = PaymentStatus.PENDING
        payment.save(failOnError: true)
        return payment
     }

        public Payment recognizePayment(paymentId) {
        Payment payment = Payment.get(paymentId)
        payment.status = PaymentStatus.PAID
        payment.save(failOnError: true)
        return payment
     }

    public List<Payment> list() {
        return Payment.getAll()
    }

    public Payment getPayment(Long id) {
        return Payment.get(id)
    }
}
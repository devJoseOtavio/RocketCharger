package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.enums.PaymentMethod
import com.rocketcharger.enums.PaymentStatus
import com.rocketcharger.utils.FormatDateUtils
import com.rocketcharger.domain.EmailService

import grails.gorm.transactions.Transactional
import grails.gsp.PageRenderer

@Transactional
class PaymentService {
    PageRenderer groovyPageRenderer
    def emailService
    
    public Payment save(Map params) {
        Payment payment = new Payment()
        payment.value = new BigDecimal(params.value)
        payment.dueDate = FormatDateUtils.toDate(params.dueDate, "yyyy-MM-dd")
        payment.billingType = PaymentMethod.valueOf(params.billingType)
        payment.payer = Payer.get(params.long("payerId"))
        payment.customer = Customer.get(params.long("customerId"))
        payment.status = PaymentStatus.PENDING
        payment.save(failOnError: true)
        String subject = "Notificação de nova cobrança"
        try {
            emailService.sendEmail(payment.customer.email, subject, groovyPageRenderer.render(template: "/email/emailSendCustomerPayment", model: [payment: payment]))
            emailService.sendEmail(payment.payer.email, subject, groovyPageRenderer.render(template: "/email/emailSendPayerPayment", model: [payment: payment]))
        } catch (Exception e) {
            e.printStackTrace()
        }
        return payment
    }

    public Payment recognizePayment(paymentId) {
        Payment payment = Payment.get(paymentId)
        payment.status = PaymentStatus.PAID
        payment.paymentDate = new Date()
        payment.save(flush: true, failOnError: true)
        String subject = "Notificação cobrança confirmada"
        emailService.sendEmail(payment.customer.email, subject, groovyPageRenderer.render(template: "/email/emailConfirmCustomerPayment", model: [payment: payment]))
        emailService.sendEmail(payment.payer.email, subject, groovyPageRenderer.render(template: "/email/emailConfirmPayerPayment", model: [payment: payment]))
        return payment
    }

    public List<Payment> list() {
        return Payment.getAll()
    }

    public Payment getPayment(Long id) {
        return Payment.get(id)
    }

    public List<Payment> returnPaymentsByCustomer(Long customerId, Integer max, Integer offset) {
        List<Payment> paymentList = Payment.createCriteria().list(max: max, offset: offset){
            eq("customer", Customer.get(customerId))
        }
        return paymentList
    }

    public List<Payment> returnPaymentStatusDate(PaymentStatus paymentStatus, Date yesterdayDate) {
        List<Payment> paymentList = Payment.createCriteria().list() {
            eq("status", paymentStatus) and {
                ge("dueDate", yesterdayDate)
            }
        }
        return paymentList
    }
}
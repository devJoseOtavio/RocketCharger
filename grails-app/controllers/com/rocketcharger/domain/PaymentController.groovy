package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class PaymentController {
     
    def paymentService
    def payerService

     
   def index() {  
        Long customerId = params.long("customerId")
        List<Payment> paymentList = paymentService.returnPayersByCustomer(customerId, returnSizeLimitPage(), getCurrentPage())
        return [customerId: customerId, paymentList: paymentList, totalCount: Payment.count()]
    }

    def create() {
        Long customerId = params.long("customerId")
        List<Payer> payerList = payerService.returnPayersByCustomer(customerId)
        return [customerId: customerId, payerList: payerList]
    }

    def save() {
        try {
            Payment payment = paymentService.save(params)
            if (payment) render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Ocorreu um erro"] as JSON)
        } 
    }

    def update() {
       try {
            paymentService.update(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Erro ao tentar atualizar"] as JSON)
        } 
    }

    def show() {
        return [payment: Payment.get(params.long("paymentId"))]
    }
 }
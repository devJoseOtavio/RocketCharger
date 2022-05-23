package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class PaymentController {
     def paymentService

     
   def index() {  
        Long customerId = params.long("id")
        List<Payment> paymentList = Payment.createCriteria().list(max: 10, offset: getCurrentPage()) {
            like("customer", Customer.get(customerId)) 
        }
        [paymentList: paymentList, totalCount: Payment.count()]
    }

    def create() {
        Long customerId = params.long("id")
        List<Payer> payerList = Payer.createCriteria().list() {
            like("customer", Customer.get(customerId)) 
        }
        [payerList: payerList, totalCount: Payer.count()]
        return [customerId: customerId, payerList: payerList]
    }

    def save() {
        try {
            paymentService.save(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            println e
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
        return [payment: paymentService.getPayment(params.int("id"))]
    }
    
    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
 }
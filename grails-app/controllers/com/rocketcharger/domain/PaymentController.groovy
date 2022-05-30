package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.base.BaseController

import static org.springframework.http.HttpStatus.*
import grails.validation.ValidationException
import grails.converters.JSON

class PaymentController {
     def paymentService

     
   def index() {  
        Long customerId = params.long("customerId")
        List<Payment> paymentList = Payment.createCriteria().list(max: returnSizeLimitPage(), offset: getCurrentPage()) {
            like("customer", Customer.get(customerId)) 
        }
        return [paymentList: paymentList, totalCount: Payment.count()]
    }

    def create() {
        Long customerId = params.long("customerId")
        List<Payer> payerList = Payer.createCriteria().list() {
            like("customer", Customer.get(customerId)) 
        }
        return [payerList: payerList, totalCount: Payer.count(), customerId: customerId, payerList: payerList]
    }

    def save() {
        try {
            paymentService.save(params)
            render([success: true] as JSON)
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
        return [payment: Payment.get(id)]
    }
    
    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
 }
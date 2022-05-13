package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class PaymentController {

    def paymentService

    def index() {
        return [paymentList: Payment.list(max: 2, offset: getCurrentPage()), totalCount: Payment.count()]
    }


    def create() { }

     def save() {
        try {
            paymentService.save(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Erro ao tentar salvar"] as JSON)
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

package com.rocketcharger.domain

import static org.springframework.http.HttpStatus.*
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.converters.JSON

class PayerController {
    def payerService

    def index() {
        Integer customerId = params.int("id")
        List <Payer> payerList = Payer.createCriteria().list(max: 10, offset: getCurrentPage()) {
            like("customer", Customer.get(customerId))
        }
        [payerList: payerList, totalCount: Payer.count()]
    }

    def create() {
        return [customerId: params.int("id")]
    }

    def save() {
        try {
            Payer payer = payerService.validate(params)
            
            if (payer.hasErrors()) {
                render([success: false, message: message(code: payer.errors.allErrors.defaultMessage)] as JSON)
                return
            }
            payer = payerService.save(params)
            
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: message(code: "Ocorreu um erro: " + e.message)] as JSON)
        }
    }

    def update() {
        try {
            Payer payer = payerService.validate(params)
            
            if (payer.hasErrors()) {
                render([success: false, message: message(code: payer.errors.allErrors.defaultMessage)] as JSON)
                return
            }
            payer = payerService.update(params)
            
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: message(code: "Ocorreu um erro: " + e.message)] as JSON)
        }
    }

    def show() {
        return [payer: payerService.getPayer(params.int("id"))]
    }

    private Integer getCurrentPage() {
        if (!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
}
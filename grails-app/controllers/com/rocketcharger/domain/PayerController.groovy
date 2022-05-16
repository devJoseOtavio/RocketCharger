package com.rocketcharger.domain

import static org.springframework.http.HttpStatus.*

import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer

import grails.converters.JSON

class PayerController {

    def payerService

    def index() {
        Integer customerId = params.long('id')
        List <Payer> payerList = Payer.createCriteria().list(max: 10, offset: getCurrentPage()) {
            like("customer", Customer.get(customerId)) 
        }
        [payerList: payerList, totalCount: Payer.count()]
    }

    def create() {
        return [customerId: params.long('id')]
    }

    def save() {
        try {
            Payer payer = payerService.save(params)
            if (payer.hasErrors()) {
                render([success: false, message: message(code: payer.errors.allErrors[0].defaultMessage ?: payer.errors.allErrors[0].codes[0])] as JSON)
                return;
            }
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: "Erro ao tentar salvar: " + e] as JSON)
        }
    }

    def update() {
        try {
            Long id = params.long('id')
            payerService.update(id, params)
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: 'Erro ao tentar atualizar'] as JSON)
        }
    }

    def show() {
        return [payer: Payer.get(params.long('id'))]
    }

    private Integer getCurrentPage() {
        if (!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
}
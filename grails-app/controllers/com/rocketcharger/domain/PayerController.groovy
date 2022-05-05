package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer

import grails.validation.ValidationException

import grails.converters.JSON

class PayerController {

    def payerService

    def index() {
        return [payerList: Payer.list(max: 2, offset: getCurrentPage()), totalCount: Payer.count()]
    }

    def create() { }

     def save() {
        try {
            payerService.save(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Erro ao tentar salvar"] as JSON)
        } 
    }

    def update() {
        try {
            payerService.update(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Erro ao tentar atualizar"] as JSON)
        } 
    }

    def show() {
         return [payer: payerService.getPayer(params.int("id"))]
    }

    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
}

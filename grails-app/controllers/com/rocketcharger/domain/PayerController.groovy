package com.rocketcharger.domain

import static org.springframework.http.HttpStatus.*

import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer

import grails.validation.ValidationException

import grails.converters.JSON

class PayerController {
    def payerService

    def index() {  
       return [payerList: Payer.getAll()]
    }

    def create() {
       
        return [customerId: params.int('id')]
    }

    def save () {
        try {
            payerService.save(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Ocorreu um erro"] as JSON)
        } 
    }
}


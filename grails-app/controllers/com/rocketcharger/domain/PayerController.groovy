package com.rocketcharger.domain

import com.rocketcharger.domain.payer.Payer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PayerController {
    def payerService

    def index() {  
       return [payerList: Payer.getAll()]
  
    }

    def adicionar() {
        return [lista: Payer.getAll()]
    }

    def save () {
        try {
            payerService.save(params)
            render("ok")
        } catch(Exception e) {
            println(e)
        } 
    }
}

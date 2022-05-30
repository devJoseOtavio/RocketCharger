package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.base.BaseController

import static org.springframework.http.HttpStatus.*
import grails.validation.ValidationException
import grails.converters.JSON

class CustomerController {
     def customerService

   def index() {  
        return [customerList: Customer.list(max: returnSizeLimitPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }

    def create() {}

    def save() {
        try {
            customerService.save(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Ocorreu um erro"] as JSON)
        } 
    }

    def update() {
       try {
            customerService.update(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Erro ao tentar atualizar"] as JSON)
        } 
    }

    def show() {
        return [customer: Customer.get(params.int("id"))]
    }

    def customerPage() {
        return [customerList: Customer.list(max: 10, offset: getCurrentPage()), totalCount: Customer.count()]
    }
 }
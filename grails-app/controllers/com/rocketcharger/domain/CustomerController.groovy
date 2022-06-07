package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured


class CustomerController {
     def customerService

     
   def index() {  
        return [customerList: Customer.list(max: 10, offset: getCurrentPage()), totalCount: Customer.count()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
    }

    def save() {
        try {
            Customer customer = customerService.save(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Ocorreu um erro"] as JSON)
        } 
    }

    def update() {
       try {
            Long id = params.long("id")
            customerService.update(id, params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Erro ao tentar atualizar"] as JSON)
        } 
    }

    def show() {
        return [customer: Customer.get(params.long("id"))]
    }

    def customerPage() {
        return [customerList: Customer.list(max: 10, offset: getCurrentPage()), totalCount: Customer.count()]
    }
    
    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
 }
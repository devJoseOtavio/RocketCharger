package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class CustomerController {
     def customerService
     
   def index() {  
        return [customerList: Customer.list(max: 10, offset: getCurrentPage()), totalCount: Customer.count()]
    }

    def create() {
    }

    def save() {
        try {
            Customer customer = customerService.validate(params)

            if (customer.hasErrors()) {
                render([success: false, message: message(code: customer.errors.allErrors.defaultMessage)] as JSON)
                return
            }
            customer = customerService.save(params)
            
            
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: message(code: "Ocorreu um erro: " + e.message)] as JSON)
        }
    }

    def update() {
        try {
            Customer customer = customerService.validate(params)

            if (customer.hasErrors()) {
                render([success: false, message: message(code: customer.errors.allErrors.defaultMessage)] as JSON)
                return
            }
            customer = customerService.update(params)

        } catch(Exception e) {
            render([success: false, message: message(code: "Ocorreu um erro: " + e.message)] as JSON)
        } 
    }

    def show() {
        return [customer: customerService.getCustomer(params.int("id"))]
    }

    def customerPage() {
        return [customerList: Customer.list(max: 10, offset: getCurrentPage()), totalCount: Customer.count()]
    }
    
    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
 }
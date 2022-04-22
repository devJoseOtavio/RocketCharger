package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class CustomerController {
     def customerService

     
   def index() {  
        return [customerList: Customer.getAll()]
    }

    def create() {
    }

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
            customerService.save(params)
            Map info = [customer: customerService.getCustomer(params.int("id"))]
            render([success: true, html: g.render(template:"/customer/template/show/_form", model: info)] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Ocorreu um erro"] as JSON)
        } 
    }

    def show() {
        return [customer: customerService.getCustomer(params.int("id"))]
    }
 }
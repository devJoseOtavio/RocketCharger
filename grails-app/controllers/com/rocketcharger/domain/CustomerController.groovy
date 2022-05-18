package com.rocketcharger.domain

import com.rocketcharger.base.BaseController
import com.rocketcharger.domain.customer.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class CustomerController extends BaseController{
    def customerService

    def index() {}

    def create() {}

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
            Customer customer = customerService.update(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: "Erro ao tentar atualizar"] as JSON)
        } 
    }

    def show() {
        return [customer: Customer.get(params.long("customerId"))]
    }

    def list() {
        return [customerList: Customer.list(max: returnSizeLimitPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }
 }
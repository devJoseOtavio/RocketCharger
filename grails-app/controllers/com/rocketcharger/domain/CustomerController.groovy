package com.rocketcharger.domain

import com.rocketcharger.base.BaseController
import com.rocketcharger.domain.customer.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.validation.ValidationException
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured


class CustomerController extends BaseController {
    
 
    def customerService

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
    }

    def index() {  
        return [customerList: Customer.list(max: getSizeLimitPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }

    def save() {
        try {
            Customer customer = customerService.save(params)

            if (customer.hasErrors()) {
                render([success: false, message: message(code: customer.errors.allErrors[0].defaultMessage ?: customer.errors.allErrors[0].codes[0])] as JSON)
                return
            }

            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: message(code: "occurrence.error")] as JSON)
        }
    }

    def update() {
        try {
            Customer customer = customerService.update(params)

            if (customer.hasErrors()) {
                render([success: false, message: message(code: customer.errors.allErrors[0].defaultMessage ?: customer.errors.allErrors[0].codes[0])] as JSON)
                return
            }

            render([success: true] as JSON)
        } catch(Exception e) {
            render([success: false, message: message(code: "occurrence.error")] as JSON)
        } 
    }

    def show() {
        return [customer: Customer.get(params.long("id"))]
    }

    def list() {
        return [customerList: Customer.list(max: getSizeLimitPage(), offset: getCurrentPage()), totalCount: Customer.count()]
    }
 }
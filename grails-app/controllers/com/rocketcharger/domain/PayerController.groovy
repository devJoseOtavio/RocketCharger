package com.rocketcharger.domain

import static org.springframework.http.HttpStatus.*
import com.rocketcharger.base.BaseController
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.converters.JSON

class PayerController extends BaseController {
    
    def payerService

    def index() {
        Integer customerId = params.int("id")
        List<Payer> payerList = Payer.createCriteria().list(max: getSizeLimitPage(), offset: getCurrentPage()) {
            like("customer", Customer.get(customerId)) 
        }
        return [payerList: payerList, totalCount: Payer.count()]
    }

    def create() {
        return [customerId: params.long("id")]
    }

    def save() {
        try {
            Payer payer = payerService.save(params)
            
            if (payer.hasErrors()) {
                render([success: false, message: message(code: payer.errors.allErrors[0].defaultMessage ?: payer.errors.allErrors[0].codes[0])] as JSON)
                return
            }
            
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: message(code: "occurrence.error")] as JSON)
        }
    }

    def update() {
        try {
            Payer payer = payerService.update(params)
            
            if (payer.hasErrors()) {
                render([success: false, message: message(code: payer.errors.allErrors[0].defaultMessage ?: payer.errors.allErrors[0].codes[0])] as JSON)
                return
            }
            
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: message(code: "occurrence.error")] as JSON)
        }
    }

    def show() {
        return [payer: Payer.get(params.long("id"))]
    }
}
package com.rocketcharger.domain

import static org.springframework.http.HttpStatus.*
import com.rocketcharger.base.BaseController
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer

import grails.converters.JSON

class PayerController extends BaseController{
    def payerService

    def index() {
        Long customerId = params.long("id")
        List<Payer> payerList = payerService.returnPayersByCustomer(customerId, returnSizeLimitPage(), getCurrentPage())
        return [customerId: customerId, payerList: payerList, totalCount: Payer.count()] 
        render(template:"list", model:[customerId: customerId, payerList: payerList])
    }

    def create() {
        return [customerId: params.long("id")]
    }

    def save() {
        try {
            payerService.save(params)
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: 'Ocorrreu um erro: ' + e.message]  as JSON)
        }
    }

    def update() {
        try {
            payerService.update(params)
            render([success: true] as JSON)
        } catch (Exception e) {
            render([success: false, message: 'Ocorrreu um erro: ' + e.message ]  as JSON)
        }
    }

    def show() {
        return [payer: payerService.getPayer(params.long("id"))]
    }
}
package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import com.rocketcharger.base.BaseController
import com.rocketcharger.enums.PaymentMethod


class PaymentController extends BaseController {
    def paymentService
    def payerService

   def index() {  
        Long customerId = params.long("id")
        List<Payment> paymentList = paymentService.returnPaymentsByCustomer(customerId, returnSizeLimitPage(), getCurrentPage())
        return [customerId: customerId, paymentList: paymentList, totalCount: paymentList.size()]
    }

    def create() {
        Long customerId = params.long("id")
        List<Payer> payerList = payerService.returnPayersByCustomer(customerId)
        return [customerId: customerId, payerList: payerList]
    }

    def save() {
        try {
            paymentService.save(params)
            render([success: true] as JSON)
        } catch(Exception e) {
            print e
            render([success: false, message: "Ocorreu um erro"] as JSON)
        } 
    }

    def confirm() {
        Long paymentId = params.long("id")
        try {
            paymentService.recognizePayment(paymentId)
            redirect controller: "payment", action: "index", id: paymentId
            }
         catch (Exception e) {
            render([success: false, message: "Erro, tente novamente"] as JSON)
        }
    }

    def show() {
        return [payment: Payment.get(params.long("id"))]
    }
 }
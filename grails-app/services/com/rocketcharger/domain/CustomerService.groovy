package com.rocketcharger.domain

import grails.gorm.transactions.*
import com.rocketcharger.domain.customer.Customer

class CustomerService {

     def save(Map params) {
         Customer customer = new Customer(params)
         customer.save(failOnError: true)
     }

    def getCustomer(Integer id){
        return Customer.get(id)
    }

    def update(Map params){
         if (params.id) {
            Customer customer = Customer.get(params.int("id"))
            customer.name = params.name
            customer.email = params.email
            customer.cpfCnpj = params.cpfCnpj
            customer.postalCode = params.postalCode
            customer.address = params.address
            customer.province = params.province
            customer.city = params.city
            customer.state = params.state
            customer.save(flush: true, failOnError: true)
       } else {
            throw new Exception("Erro ao realizar edição")
       }
    }
}
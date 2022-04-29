package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {

     def save(Map params) {
         Customer customer = new Customer(params)
         customer.save(failOnError: true)
         return customer
     }

      def index() {
        return Customer.getAll()
      }

    def getCustomer(Integer id) {
        return Customer.get(id)
    }

    def update(Map params) {
        if (params.id) {
            Customer customer = Customer.get(params.int('id'))
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
            throw new Exception('Erro ao realizar edição')
        }
    }

}


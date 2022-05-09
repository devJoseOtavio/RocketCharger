package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional 

@Transactional
class CustomerService {

     def save(Map params) {
         Customer customer = new Customer(params)
         customer.save(failOnError: true)
     }

      def index() {
        return Customer.getAll()
    }

    def getCustomer(Integer id){
        return Customer.get(id)
    }

}
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

    def update(Long id, Map params) {
        if (!id) return;
        Customer customer = Customer.get(params.long("id"))
        customer.name = params.name
        customer.email = params.email
        customer.cpfCnpj = params.cpfCnpj
        customer.postalCode = params.postalCode
        customer.address = params.address
        customer.district = params.district
        customer.city = params.city
        customer.state = params.state
        customer.save(failOnError: true)
        return customer;
    } 
}
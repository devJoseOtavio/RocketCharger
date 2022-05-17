package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional 

@Transactional
class CustomerService {

    public Customer save(Map params) {
         Customer customer = new Customer(params)
         customer.save(failOnError: true)
     }

    public List<Customer> index() {
        return Customer.getAll()
    }

    public Customer getCustomer(Integer id){
        return Customer.get(id)
    }

    public Customer update(Map params){
        if (!params.id) {
        return;
    }   
        Customer customer = Customer.get(params.int("id"))
        customer.name = params.name
        customer.email = params.email
        customer.cpfCnpj = params.cpfCnpj
        customer.postalCode = params.postalCode
        customer.address = params.address
        customer.district = params.district
        customer.city = params.city
        customer.state = params.state
        customer.save(flush: true, failOnError: true)
    } 
}
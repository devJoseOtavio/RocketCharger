package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.utils.DomainUtils
import com.rocketcharger.utils.ValidateUtils
import grails.gorm.transactions.Transactional 

@Transactional
class CustomerService {

    public Customer save(Map params) {
         Customer customer = new Customer(params)
         ValidateUtils.emailIsValid(params.email)
         ValidateUtils.isNumeric(params.postalCode)
         customer.save(failOnError: true)
         return customer
    }

    public List<Customer> index() {
        return Customer.getAll()
    }

    public Customer getCustomer(Integer id){
        return Customer.get(id)
    }

    public Customer update(Map params){
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
        return customer
    }

    public Customer validate(Map params) {
        Customer customer = new Customer()
        if (!params.name) {
            DomainUtils.addError(customer, "")
        }
        if (!params.email) {
            DomainUtils.addError(customer, "")
        }
        if (!params.cpfCnpj) {
            DomainUtils.addError(customer, "")
        }
        if (!params.postalCode) {
            DomainUtils.addError(customer, "")
        }
        if (!params.address) {
            DomainUtils.addError(customer, "")
        }
        if (!params.district) {
            DomainUtils.addError(customer, "")
        }
        if (!params.city) {
            DomainUtils.addError(customer, "")
        }
        if (!params.state) {
           DomainUtils.addError(customer, "")
        }
        return customer
    } 
}
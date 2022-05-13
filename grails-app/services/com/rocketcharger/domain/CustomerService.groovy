package com.rocketcharger.domain

import com.rocketcharger.domain.customer.Customer
import grails.gorm.transactions.Transactional 

@Transactional
class CustomerService {

    public Customer save(Map params) {
         validate(params)
         Customer customer = new Customer(params)
         customer.save(failOnError: true)
         return customer;
     }

    public List <Customer> index() {
        return Customer.getAll()
    }

    public Customer getCustomer(Integer id){
        return Customer.get(id)
    }

    public Customer update(Map params){
        if (!params.id) throw new Exception('Erro ao realizar edição')
        validate(params)
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
        return customer;
    }

    private void validate(Map params){
        if(!params.name){
            throw new Exception('Erro no registro do nome informado.')
        }
        if(!params.email){
            throw new Exception('Erro no registro do email informado.')
        }
        if(!params.cpfCnpj){
            throw new Exception('Erro na registro de CPF/CNPJ.')
        }
        if(!params.postalCode){
            throw new Exception('Erro no registro do CEP informado.')
        }
        if(!params.address){
            throw new Exception('Erro no registro do endereço informado.')
        }
        if(!params.district){
            throw new Exception('Erro no registro do bairro informado.')
        }
        if(!params.city){
            throw new Exception('Erro no registro da cidade informada.')
        }
        if(!params.state){
            throw new Exception('Erro no registro do Estado informada.')
        }
    } 
}
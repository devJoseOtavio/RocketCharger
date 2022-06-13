package com.rocketcharger.domain

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

import com.rocketcharger.domain.User
import com.rocketcharger.domain.Role
import com.rocketcharger.domain.UserRole
import com.rocketcharger.domain.CustomUserDetails
import com.rocketcharger.domain.customer.Customer

@Transactional
class RegisterService {

    public register(Map params) {
        Customer customer = connectCustomer(params.username)
        User user = connectUser(params.username, params.password, customer)
        connectRoleUser(user)
        return user
    }

    public User connectUser(String username, String password, Customer customer) {
        User user = new User()
        user.username = username
        user.password = password
        user.customer = customer
        user.save(flush: true)
        return user
    }

    public Customer connectCustomer(String email) {
        Customer customer = new Customer()
        customer.email = email
        customer.save(failOnError: true)
    }

        public connectRoleUser(User user) {
        def role = Role.get(2)
        UserRole.create(user, role)
        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }

}


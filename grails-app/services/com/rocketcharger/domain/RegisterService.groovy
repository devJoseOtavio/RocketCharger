package com.rocketcharger.domain

import com.rocketcharger.domain.User
import com.rocketcharger.domain.Role
import com.rocketcharger.domain.UserRole
import com.rocketcharger.domain.CustomUserDetails
import com.rocketcharger.domain.customer.Customer

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

@Transactional
class RegisterService {

    public register(Map params) {
        User user = new User()
        Customer customer = new Customer()
        customer.email = user.username
        customer.save(failOnError: true)
        user.username = params.username
        user.password = params.password
        user.save(failOnError: true)
        def role = Role.get(2)

        UserRole.create(user, role)

        UserRole.withSession {
            it.flush()
            it.clear()
        }
        return user
    }
}


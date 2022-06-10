package com.rocketcharger.domain

import com.rocketcharger.domain.User
import com.rocketcharger.domain.Role
import com.rocketcharger.domain.UserRole
import com.rocketcharger.domain.CustomUserDetails

import grails.validation.ValidationException
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

@Transactional
class RegisterService {

    public register(Map params) {
        Role role = Role.get(2)
        User user = new User()
        user.username = params.username
        user.password = params.password
        findRoleUser(user)
        user.save(flush: true)
        return user
    }

    private void findRoleUser(User user) {
        Role role = Role.get(2)
        UserRole.create(user, role)
        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
}

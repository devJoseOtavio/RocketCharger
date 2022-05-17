package com.rocketcharger.domain.payment

import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.enums.PaymentMethod
import com.rocketcharger.enums.PaymentStatus

class Payment {

    String value

    String billingType
    
    String status

    String dueDate

    Customer customer
    
    Payer payer

    static constraints = {

    }
}

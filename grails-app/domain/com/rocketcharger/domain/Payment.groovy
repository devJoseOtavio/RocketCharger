package com.rocketcharger.domain.payment

import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.enums.PaymentStatus
import com.rocketcharger.enums.PaymentMethod

class Payment {

    String value

    PaymentMethod billingType
    
    PaymentStatus status

    Date dueDate

    Customer customer
    
    Payer payer

    static constraints = {
        value nullable: false
        billingType nullable: false
        status nullable: false
        dueDate nullable: false
        customer nullable: false
        payer nullable: false
    }
}

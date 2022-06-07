package com.rocketcharger.domain.payment

import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.domain.payer.Payer

class Payment {

    BigDecimal value

    String billingType
    
    String status

    Date dueDate

    Date paymentDate

    Customer customer
    
    Payer payer
    
     static constraints = {
        paymentDate nullable: true
    }
}

package com.rocketcharger.utils

import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.domain.payer.Payer

class ValidateUtils {

    public static Boolean emailIsValid(String email) {
        return email ==~ /[A-Za-z0-9_\%\+-]+(\.[A-Za-z0-9_\%\+-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9-]+)*(\.[A-Za-z]{2,15})/
    }

    public static Boolean postalCodeIsValid(String postalCode) {
        if (postalCode == null) return null
        return postalCode?.replaceAll("\\D+","")
    }
}
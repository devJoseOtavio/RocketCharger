package com.rocketcharger.domain.payer

class Payer {

    String name
    String email
    String cpfCnpj
    String postalCode
    String address
    String district
    String city
    String state
    
     static constraints = {
<<<<<<< HEAD
        name size: 3..100, nulllable: true
        email size: 5..100, nulllable: true

=======
>>>>>>> 1fce4c2aad4b0e7358d7fa8d0387741786479bfc
    }
}
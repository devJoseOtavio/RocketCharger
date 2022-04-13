package com.rocketcharger.domain.payer

class Payer {

    String name
    String email
    Date nascimento
    String cep
    String endereco
    String cidade
    String estado
    
    
     static constraints = {
        name size: 3..100, nulllable: true
        id size: 10..10, nulllable: true
        email size: 5..100, nulllable: true

    }
}
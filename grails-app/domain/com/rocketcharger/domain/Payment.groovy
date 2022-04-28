package com.rocketcharger.domain.payment

class Payment {

    String billingType
    String status
    String dueDate

     static constraints = {
        billingType InList: ['Cartão de Crédito', 'Pix', 'Boleto']
        status InList: ['Aguardando pagamento', 'Pago', 'Vencido']
     }

}

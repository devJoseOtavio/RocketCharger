package com.rocketcharger.domain

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.payer.Payer
import com.rocketcharger.domain.customer.Customer
import com.rocketcharger.enums.PaymentMethod
import com.rocketcharger.enums.PaymentStatus
import com.rocketcharger.utils.FormatDateUtils

import grails.gorm.transactions.Transactional 

@Transactional
class PaymentService {

   public Payment save(Map params) {
        Payment payment = new Payment()
        payment.value = new BigDecimal(params.value)
        payment.dueDate = FormatDateUtils.toDate(params.dueDate, "yyyy-MM-dd")
        payment.billingType = params.billingType
        payment.payer = Payer.get(params.long("payerId"))
        payment.customer = Customer.get(params.long("customerId"))
        payment.status = params.status
        payment.save(failOnError: true)
        return payment
    }

    public List<Payment> list() {
        return Payment.getAll()
    }

    public Payment getPayment(Long id) {
        return Payment.get(id)
    }

    public List<Payment> returnPaymentsByCustomer(Long customerId, Integer max = null, Integer offset = null) {
        List<Payment> paymentList = Payment.createCriteria().list(max: max, offset: offset){
            eq("customer", Customer.get(customerId))
        }
        return paymentList
    }

    public List<Payment> list(PaymentStatus paymentStatus, Date yesterdayDate) {
        List<Payment> paymentList = Payment.createCriteria().list() {
            eq("status", paymentStatus) and {
                le("dueDate", yesterdayDate)
            }
        }
        return paymentList
    }

    public Payment verifyOverDueDates() {
        Date yesterdayDate = FormatDateUtils.getYesterdayDate()
        List<Payment> paymentList = list(PaymentStatus.PENDING, yesterdayDate)
          for(Payment payment : paymentList) {
              payment.status = PaymentStatus.OVERDUE
              payment.save(failOnError:true)
        }
    }
}
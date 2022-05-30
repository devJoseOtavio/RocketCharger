package rocket.charger

import com.rocketcharger.domain.payment.Payment
import com.rocketcharger.domain.PaymentService
import com.rocketcharger.utils.FormatDateUtils
import com.rocketcharger.enums.PaymentStatus

import grails.gorm.transactions.Transactional

@Transactional
class OverDueJob {
    def paymentService

    static triggers = {
      cron name: "dueDate", cronExpression: "0/50 * * ? * * *"
    }

    static concurrent = false

    def execute() {
      paymentService.verifyOverDueDates()
    }
}
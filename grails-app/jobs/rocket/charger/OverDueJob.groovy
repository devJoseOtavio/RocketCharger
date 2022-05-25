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

    def execute() {
        Date yesterdayDate = FormatDateUtils.getYesterdayDate()
        List<Payment> paymentList = paymentService.returnPaymentStatusDate(PaymentStatus.PENDING, yesterdayDate)
          for(Payment payment : paymentList) {
              payment.status = PaymentStatus.OVERDUE
              payment.save(failOnError:true)
        }
    }
}

package com.rocketcharger.domain

import java.sql.Timestamp

class EmailSenderController {

    def index() {}
    
    def send() {
        sendMail {
            to params.sendEmail
            subject params.sendSubject
            text params.sendMessage
        }

        flash.message = "Message sent at "+new Date()
        redirect action:"index"
    }
}
package com.ranijth.service

import com.ranijth.classes.PaymentDetails
import com.ranijth.payment.PaymentFactory
import org.springframework.stereotype.Service

@Service
class PaymentService {

    fun processPayment(paymentAmount: Double): PaymentDetails {
        print("Enter the mode of Payment: ")
        val paymentMode = readlnOrNull() ?: throw IllegalArgumentException("Payment mode cannot be empty")
        val paymentModeObject = PaymentFactory().getPaymentMode(paymentMode)
        val paymentStatus = paymentModeObject.makePayment(paymentAmount)
        return PaymentDetails(paymentModeObject, paymentAmount, paymentStatus)
    }
}
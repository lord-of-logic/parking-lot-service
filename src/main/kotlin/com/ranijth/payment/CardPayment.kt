package com.ranijth.payment

import com.ranijth.enums.PaymentStatus

class CardPayment(
    private var cardNumber: String? = null,
    private var expiryDate: String? = null,
    private var cvv: String? = null
): PaymentMode {
    override fun makePayment(paymentAmount: Double): PaymentStatus {
        print("Enter the Card Number: ")
        cardNumber = readlnOrNull() ?: throw IllegalArgumentException("Card number cannot be empty")
        print("Enter the Expiry Data: ")
        expiryDate = readlnOrNull() ?: throw IllegalArgumentException("Expiry date cannot be empty")
        print("Enter the CVV: ")
        cvv = readlnOrNull() ?: throw IllegalArgumentException("CVV cannot be empty")
        return PaymentStatus.PAID
    }
}
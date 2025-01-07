package com.ranijth.payment

import com.ranijth.enums.PaymentStatus

class UPIPayment(
    private var upiId: String? = null
): PaymentMode {
    override fun makePayment(paymentAmount: Double): PaymentStatus {
        print("Enter the UPI Id: ")
        upiId = readlnOrNull() ?: throw IllegalArgumentException("UPI Id cannot be empty")
        return PaymentStatus.PAID
    }
}
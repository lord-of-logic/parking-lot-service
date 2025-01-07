package com.ranijth.payment

import com.ranijth.enums.PaymentStatus

class CashPayment: PaymentMode {
    override fun makePayment(paymentAmount: Double): PaymentStatus {
        print("Pay the amount in cash to cashier")
        return PaymentStatus.PAID
    }
}
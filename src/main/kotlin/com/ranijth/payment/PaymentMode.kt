package com.ranijth.payment

import com.ranijth.enums.PaymentStatus

interface PaymentMode {
    fun makePayment(paymentAmount: Double): PaymentStatus
}
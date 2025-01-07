package com.ranijth.classes

import com.ranijth.enums.PaymentStatus
import com.ranijth.payment.PaymentMode

class PaymentDetails(
    val paymentMode: PaymentMode,
    val paymentAmount: Double,
    val paymentStatus: PaymentStatus
)
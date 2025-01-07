package com.ranijth.payment

class PaymentFactory {
    fun getPaymentMode(paymentMode: String): PaymentMode {
        return when(paymentMode) {
            "CASH" -> CashPayment()
            "UPI" -> UPIPayment()
            "CARD" -> CardPayment()
            else -> throw IllegalArgumentException("Invalid payment mode")
        }
    }
}
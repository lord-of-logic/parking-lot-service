package com.ranijth.`object`

object ParkingTicketSequenceGenerator {
    private var sequenceNumber = 0
    fun nextSequenceNumber(): String {
        return "PKT-${sequenceNumber++}"
    }
}
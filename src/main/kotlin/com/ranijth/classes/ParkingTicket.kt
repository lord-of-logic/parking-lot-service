package com.ranijth.classes

import com.ranijth.amenities.Amenity
import java.time.LocalDateTime

class ParkingTicket(
    var parkingTicketNumber: String,
    var vehicle: Vehicle,
    val parkingSpot: ParkingSpot,
    private var parkingStartTime: LocalDateTime,
    var parkingEndTime: LocalDateTime? = null,
    var parkingFee: Double = 0.0,
    var paymentDetails: PaymentDetails? = null,
    private val consumedAmenities: MutableList<Amenity>
) {
    fun calculateParkingFee(): Double {
        val parkingDuration = parkingEndTime!!.minusMinutes(parkingStartTime.minute.toLong())
        parkingFee += parkingDuration.minute * parkingSpot.parkingChargePerMinute
        parkingFee += calculateAmenitiesFee(consumedAmenities)
        return parkingFee
    }

    private fun calculateAmenitiesFee(consumedAmenities: MutableList<Amenity>): Double {
        var amenitiesFee = 0.0
        consumedAmenities.forEach {
            amenitiesFee += it.calculateFinalFee()
        }
        return amenitiesFee
    }
}
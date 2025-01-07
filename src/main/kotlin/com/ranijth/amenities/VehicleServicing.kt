package com.ranijth.amenities

class VehicleServicing(
    private val minimumCharge: Double
) : Amenity("Vehicle Servicing", "Vehicle servicing for all types of vehicles") {
    override fun calculateFinalFee(): Double {
        val finalPrice = minimumCharge
        return finalPrice
    }
}
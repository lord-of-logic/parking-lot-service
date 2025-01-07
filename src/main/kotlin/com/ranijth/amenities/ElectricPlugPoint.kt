package com.ranijth.amenities

class ElectricPlugPoint(
    private val minimumCharge: Double
) : Amenity("Electric Plug Point", "Electric plug point for charging electric vehicles") {
    override fun calculateFinalFee(): Double {
        val finalPrice = minimumCharge
        return finalPrice
    }
}
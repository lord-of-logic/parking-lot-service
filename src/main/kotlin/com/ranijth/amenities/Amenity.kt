package com.ranijth.amenities

abstract class Amenity(
    val amenityName: String,
    val description: String
) {
    abstract fun calculateFinalFee(): Double
}
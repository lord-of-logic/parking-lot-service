package com.ranijth.amenities

class HandicappedSpot: Amenity("HandicappedSpot", "Parking spot for handicapped people") {
    override fun calculateFinalFee(): Double {
        return 0.0
    }
}
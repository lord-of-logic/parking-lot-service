package com.ranijth.classes

import com.ranijth.amenities.Amenity
import com.ranijth.enums.OccupancyStatus

class ParkingSpot(
    val spotId: String,
    val length: Double,
    val breadth: Double,
    var occupancyStatus: OccupancyStatus,
    val availableAmenities: List<Amenity>,
    val location: ParkingSpotLocation,
    val parkingChargePerMinute: Double
) {
    fun markParkingSpotAsReserved() {
        if(occupancyStatus != OccupancyStatus.AVAILABLE) {
            throw IllegalStateException("Parking spot is not available")
        }
        occupancyStatus = OccupancyStatus.RESERVED
    }

    fun markParkingSpotAsAvailable() {
        occupancyStatus = OccupancyStatus.AVAILABLE
    }

    fun markParkingSpotAsOccupied() {
        if(occupancyStatus == OccupancyStatus.AVAILABLE) {
            throw IllegalStateException("Parking spot is not reserved yet")
        }
        occupancyStatus = OccupancyStatus.OCCUPIED
    }
}
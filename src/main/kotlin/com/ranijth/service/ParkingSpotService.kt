package com.ranijth.service

import com.ranijth.amenities.Amenity
import com.ranijth.amenities.ElectricPlugPoint
import com.ranijth.amenities.HandicappedSpot
import com.ranijth.classes.ParkingSpot
import com.ranijth.classes.ParkingSpotLocation
import com.ranijth.classes.VehicleMakeAndModel
import com.ranijth.enums.OccupancyStatus
import org.springframework.stereotype.Service

@Service
class ParkingSpotService {

    fun getAvailableParkingSpot(vehicleMakeAndModel: VehicleMakeAndModel, requiredAmenities: MutableList<Amenity>): ParkingSpot {

        val availableParkingSpot = ParkingSpot(
            spotId = "A-1-1",
            length = 10.0,
            breadth = 10.0,
            parkingChargePerMinute = 0.5,
            availableAmenities = mutableListOf(HandicappedSpot(), ElectricPlugPoint(5.0)),
            location = ParkingSpotLocation(1, "A", 1, 1),
            occupancyStatus = OccupancyStatus.AVAILABLE
        )
        availableParkingSpot.markParkingSpotAsReserved()
        return availableParkingSpot
    }
}
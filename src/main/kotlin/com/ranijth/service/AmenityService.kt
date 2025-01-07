package com.ranijth.service

import com.ranijth.amenities.Amenity
import com.ranijth.amenities.ElectricPlugPoint
import com.ranijth.amenities.HandicappedSpot
import org.springframework.stereotype.Service

@Service
class AmenityService {
    fun getRequiredAmenities(): MutableList<Amenity> {
        print("Enter the Amenities required: ")
        val amenities = readlnOrNull()?.split(",")?.map { it.trim() } ?: emptyList()
        val requiredAmenities = mutableListOf<Amenity>()
        amenities.forEach {
            when (it) {
                "HandicappedSpot" -> requiredAmenities.add(HandicappedSpot())
                "ElectricPlugPoint" -> requiredAmenities.add(ElectricPlugPoint(5.0))
            }
        }
        return requiredAmenities
    }
}
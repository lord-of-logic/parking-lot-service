package com.ranijth.service

import com.ranijth.classes.Vehicle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleService {

    @Autowired
    private lateinit var vehicleMakeAndModelService: VehicleMakeAndModelService

    @Autowired
    private lateinit var vehicleOwnerService: VehicleOwnerService

    fun getVehicleDetails(): Vehicle {
        print("Enter the Registration Number of Vehicle: ")
        val vehicleRegistrationNumber = readlnOrNull() ?: throw IllegalArgumentException("Vehicle Registration Number is required")
        val vehicleMakeAndModel = vehicleMakeAndModelService.getVehicleMakeAndModel()
        val vehicleOwner = vehicleOwnerService.getVehicleOwnerDetails()
        return Vehicle(
            vehicleRegistrationNumber = vehicleRegistrationNumber,
            vehicleMakeAndModel = vehicleMakeAndModel,
            vehicleOwner = vehicleOwner
        )
    }
}
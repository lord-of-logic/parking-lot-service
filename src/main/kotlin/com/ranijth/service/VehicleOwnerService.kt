package com.ranijth.service

import com.ranijth.classes.VehicleOwner
import org.springframework.stereotype.Service

@Service
class VehicleOwnerService {

    fun getVehicleOwnerDetails(): VehicleOwner {
        print("Enter the name of Owner: ")
        val name = readlnOrNull() ?: throw IllegalArgumentException("Vehicle Owner Name is required")
        print("Enter the contact number of Owner: ")
        val contactNumber = readlnOrNull() ?: throw IllegalArgumentException("Owner Contact Number is required")
        print("Enter the Driver's License Number of Owner: ")
        val driverLicenseNumber = readlnOrNull() ?: throw IllegalArgumentException("Driver's License Number is required")
        return VehicleOwner(
            name = name,
            contactNumber = contactNumber,
            driverLicenseNumber = driverLicenseNumber
        )
    }
}
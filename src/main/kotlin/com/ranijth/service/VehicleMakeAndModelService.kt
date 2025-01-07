package com.ranijth.service

import com.ranijth.classes.VehicleMakeAndModel
import com.ranijth.mapper.VehicleMakeAndModelMapper
import com.ranijth.repository.VehicleMakeAndModelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleMakeAndModelService {

    @Autowired
    private lateinit var vehicleMakeAndModelRepository: VehicleMakeAndModelRepository

    fun getVehicleMakeAndModel(): VehicleMakeAndModel {
        print("Enter the Make of Vehicle: ")
        val vehicleMake = readlnOrNull() ?: throw IllegalArgumentException("Vehicle Make is required")
        print("Enter the Model of Vehicle: ")
        val vehicleModel = readlnOrNull() ?: throw IllegalArgumentException("Vehicle Model is required")
        val vehicleMakeAndModelEntity = vehicleMakeAndModelRepository.getByMakeAndModel(vehicleMake, vehicleModel) ?: throw Exception("Vehicle Make and Model not found")
        return VehicleMakeAndModelMapper().toDTO(vehicleMakeAndModelEntity)
    }
}
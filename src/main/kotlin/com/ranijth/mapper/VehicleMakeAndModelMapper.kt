package com.ranijth.mapper

import com.ranijth.classes.VehicleMakeAndModel
import com.ranijth.entity.VehicleMakeAndModelEntity
import org.springframework.stereotype.Component

@Component
class VehicleMakeAndModelMapper {

    fun toEntity(vehicleMakeAndModel: VehicleMakeAndModel): VehicleMakeAndModelEntity {
        return VehicleMakeAndModelEntity(
            vehicleLength = vehicleMakeAndModel.vehicleLength,
            vehicleBreadth = vehicleMakeAndModel.vehicleBreadth,
            vehicleMake = vehicleMakeAndModel.vehicleMake,
            vehicleModel = vehicleMakeAndModel.vehicleModel
        )
    }

    fun toDTO(vehicleMakeAndModelEntity: VehicleMakeAndModelEntity): VehicleMakeAndModel {
        return VehicleMakeAndModel(
            vehicleLength = vehicleMakeAndModelEntity.vehicleLength!!,
            vehicleBreadth = vehicleMakeAndModelEntity.vehicleBreadth!!,
            vehicleMake = vehicleMakeAndModelEntity.vehicleMake!!,
            vehicleModel = vehicleMakeAndModelEntity.vehicleModel!!
        )
    }
}
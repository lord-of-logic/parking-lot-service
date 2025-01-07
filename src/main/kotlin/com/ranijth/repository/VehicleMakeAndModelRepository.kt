package com.ranijth.repository

import com.ranijth.entity.VehicleMakeAndModelEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface VehicleMakeAndModelRepository: JpaRepository<VehicleMakeAndModelEntity, Long> {

    @Query("SELECT vmm FROM VehicleMakeAndModelEntity vmm WHERE vmm.vehicleMake = :vehicleMake AND vmm.vehicleModel = :vehicleModel")
    fun getByMakeAndModel(@Param("vehicleMake") vehicleMake: String, @Param("vehicleModel") vehicleModel: String): VehicleMakeAndModelEntity?
}
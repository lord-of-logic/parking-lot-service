package com.ranijth.entity

import jakarta.persistence.*

@Entity
@Table(name = "vehicle_make_and_model")
class VehicleMakeAndModelEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "vehicle_make")
    val vehicleMake: String? = null,

    @Column(name = "vehicle_model")
    val vehicleModel: String? = null,

    @Column(name = "vehicle_length")
    val vehicleLength: Double? = null,

    @Column(name = "vehicle_breadth")
    val vehicleBreadth: Double? = null,
)
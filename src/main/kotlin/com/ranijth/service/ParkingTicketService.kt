package com.ranijth.service

import com.ranijth.classes.ParkingTicket
import com.ranijth.enums.PaymentStatus
import com.ranijth.`object`.ParkingTicketSequenceGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ParkingTicketService {

    @Autowired
    private lateinit var parkingSpotService: ParkingSpotService

    @Autowired
    private lateinit var vehicleService: VehicleService

    @Autowired
    private lateinit var amenityService: AmenityService

    @Autowired
    private lateinit var paymentService: PaymentService

    private fun issueParkingTicket(): ParkingTicket {
        try {
            val vehicle = vehicleService.getVehicleDetails()
            val requiredAmenities = amenityService.getRequiredAmenities()
            val parkingSpot = parkingSpotService.getAvailableParkingSpot(vehicle.vehicleMakeAndModel, requiredAmenities)
            return ParkingTicket(
                parkingTicketNumber = ParkingTicketSequenceGenerator.nextSequenceNumber(),
                vehicle = vehicle,
                parkingSpot = parkingSpot,
                parkingStartTime = LocalDateTime.now(),
                parkingEndTime = null,
                parkingFee = 0.0,
                paymentDetails = null,
                consumedAmenities = requiredAmenities
            )
        } catch(e: Exception) {
            throw RuntimeException("Error occurred while issuing parking ticket: ${e.message}")
        }
    }

    private fun markVehicleAsParked(parkingTicket: ParkingTicket) {
        parkingTicket.parkingSpot.markParkingSpotAsOccupied()
    }

    private fun closeParkingTicket(parkingTicket: ParkingTicket) {
        parkingTicket.parkingEndTime = LocalDateTime.now()
        parkingTicket.parkingSpot.markParkingSpotAsAvailable()
        parkingTicket.calculateParkingFee()
        val paymentDetails = paymentService.processPayment(parkingTicket.parkingFee)
        parkingTicket.paymentDetails = paymentDetails
        if(parkingTicket.paymentDetails!!.paymentStatus == PaymentStatus.PAID) {
            println("Thank you for using our parking lot. Have a nice day!")
        }
        else {
            println("Payment failed. Please try again.")
        }
    }
}
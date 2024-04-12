package models


data class InvoiceModel(
    val currentBookingRequest: RoomModel,
    val clientName: String
)

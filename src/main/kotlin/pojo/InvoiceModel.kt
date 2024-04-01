package pojo


data class InvoiceModel(
    val currentBookingRequest: BookingModel,
    val bookingId: Int,
    val clientName: String)

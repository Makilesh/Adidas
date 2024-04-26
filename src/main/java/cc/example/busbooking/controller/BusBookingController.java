package cc.example.busbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cc.example.busbooking.model.BusBooking;
import cc.example.busbooking.service.BusBookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BusBookingController {

    @Autowired
    private BusBookingService busBookingService;

    @GetMapping("/get")
    public List<BusBooking> getAllBookings() {
        return busBookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BusBooking getBookingById(@PathVariable Long id) {
        return busBookingService.getBookingById(id);
    }
    @PostMapping("/post")
    public BusBooking saveBooking(@RequestBody BusBooking booking) {
        return busBookingService.saveBooking(booking);

    }
  @PutMapping("/{id}")
   public BusBooking updateBooking(@PathVariable Long id, @RequestBody BusBooking bookingDetails) {
    BusBooking booking = busBookingService.getBookingById(id);
    if (booking == null) {
        throw new RuntimeException("Booking not found with id: " + id);
    }

    booking.setPassengerName(bookingDetails.getPassengerName());
    booking.setSource(bookingDetails.getSource());
    booking.setDestination(bookingDetails.getDestination());
    booking.setFare(bookingDetails.getFare());

    return busBookingService.saveBooking(booking);
}

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        busBookingService.deleteBooking(id);
    }
}


package cc.example.busbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.example.busbooking.model.BusBooking;
import cc.example.busbooking.repository.BusBookingRepository;

import java.util.List;

@Service
public class BusBookingService {

    @Autowired
    private BusBookingRepository busBookingRepository;

    public List<BusBooking> getAllBookings() {
        return busBookingRepository.findAll();
    }

    public BusBooking getBookingById(Long id) {
        return busBookingRepository.findById(id).orElse(null);
    }

    public BusBooking saveBooking(BusBooking booking) {
        return busBookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        busBookingRepository.deleteById(id);
    }
}


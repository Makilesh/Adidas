package cc.example.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cc.example.busbooking.model.BusBooking;

@Repository
public interface BusBookingRepository extends JpaRepository<BusBooking, Long> {
    
}


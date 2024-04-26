package cc.example.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cc.example.busbooking.model.BusBooking;
import cc.example.busbooking.model.BusDetails;
import cc.example.busbooking.model.Passenger;

@Repository
public interface BusDetailsRepository extends JpaRepository<BusDetails, String> {
    @Query("SELECT p FROM BusDetails bd JOIN bd.passengers p WHERE p.gender = :gender")
    List<Passenger> findByGender(String gender);
    
    
}


package cc.example.busbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.example.busbooking.model.Passenger;
import cc.example.busbooking.repository.PassengerRepository;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passenger;

    public List<Passenger> getAllUsers() {
        return passenger.findAll();
    }
    
    public List<Passenger> findByGenderMale(String maleString){
        return passenger.findByGender(maleString);
    }
    public Passenger getUserById(String id) {
        return passenger.findById(id).orElse(null);
    }

    public Passenger saveUser(Passenger user) {
        return passenger.save(user);
    }

    public void deleteUser(String id) {
        passenger.deleteById(id);
    }
}

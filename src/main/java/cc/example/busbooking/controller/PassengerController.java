package cc.example.busbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cc.example.busbooking.model.Passenger;
import cc.example.busbooking.service.PassengerService;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService userService;

    @GetMapping("/get/{male}")
    public List<Passenger> getAllUsers(@PathVariable String male) {
        return userService.findByGenderMale(male);
    }
    
    @GetMapping("/{id}")
    public Passenger getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/post")
    public Passenger saveUser(@RequestBody Passenger user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public Passenger updateUser(@PathVariable String id, @RequestBody Passenger userDetails) {
        Passenger user = userService.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        user.setGender(userDetails.getGender());
        user.setPhoneNo(userDetails.getPhoneNo());

        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}

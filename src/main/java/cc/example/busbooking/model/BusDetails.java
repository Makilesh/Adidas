package cc.example.busbooking.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class BusDetails {
    @Id
    private String busNo;
    private String busName;
    private int totalSeats;
    private String busClass;
    @OneToOne(mappedBy="busDetails",cascade = CascadeType.ALL)
    @JsonManagedReference
    private BusBooking busBooking;

     @OneToMany(mappedBy="busDetails",cascade=CascadeType.ALL)
     @JsonManagedReference
     private List<Passenger> passengers;
}

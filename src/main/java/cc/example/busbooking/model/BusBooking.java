package cc.example.busbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public  class BusBooking {
    @Id
    private Long id;
    private String passengerName;
    private String source;
    private String destination;
    private double fare;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    private BusDetails busDetails;
}

package cc.example.busbooking.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Passenger {
    @Id
    private String phoneNo;
    private String name;
    private int age;
    private String gender;
    @ManyToOne
    @JsonBackReference
    private BusDetails busDetails;

}

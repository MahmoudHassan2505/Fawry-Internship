package org.example.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Doctor doctor;

    @ManyToMany
    @JoinTable(
            name = "patient_drug",
            joinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName = "id")
    )
    private List<Drug> drugs;
}

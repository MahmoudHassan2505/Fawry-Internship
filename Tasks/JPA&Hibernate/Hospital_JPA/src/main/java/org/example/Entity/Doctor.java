package org.example.Entity;


import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
}

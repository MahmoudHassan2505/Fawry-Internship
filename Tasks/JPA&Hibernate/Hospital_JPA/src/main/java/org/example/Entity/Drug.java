package org.example.Entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "patient_drug",
            joinColumns = @JoinColumn(name = "drug_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id")
    )
    private List<Patient> patients;





}

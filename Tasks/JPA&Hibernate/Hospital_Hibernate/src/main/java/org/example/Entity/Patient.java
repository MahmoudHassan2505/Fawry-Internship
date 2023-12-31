package org.example.Entity;


import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "patient_drug",
            joinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName = "id")
    )
    private List<Drug> drugs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }


}

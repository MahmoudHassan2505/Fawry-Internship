package org.example.Entity;


import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
    private List<Patient> patients;


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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hospital=" + hospital +
                ", patients=" + patients +
                '}';
    }
}

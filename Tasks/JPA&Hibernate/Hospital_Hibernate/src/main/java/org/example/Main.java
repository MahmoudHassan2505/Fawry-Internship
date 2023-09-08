package org.example;

import org.example.Entity.Doctor;
import org.example.Entity.Drug;
import org.example.Entity.Patient;
import org.example.repositoryies.DoctorRepository;
import org.example.repositoryies.DrugRepository;
import org.example.repositoryies.HospitalRepository;
import org.example.repositoryies.PatientRepository;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        HospitalRepository hospitalRepository = new HospitalRepository();
        DoctorRepository doctorRepository = new DoctorRepository();
        DrugRepository drugRepository = new DrugRepository();
        PatientRepository patientRepository = new PatientRepository();

//        name of Doctor working in Hospital(1-4)
//        List<Doctor> doctors = hospitalRepository.get(1).getDoctors();
//        doctors.forEach(doctor -> System.out.println(doctor.getName()));

//        name of patient with a doctor
//        List<Patient> patients = doctorRepository.get(1).getPatients();
//        patients.forEach(patient -> System.out.println(patient.getName()));

        //name of drugs that doctor writes
        doctorRepository.findAll().forEach(doctor -> {
            System.out.println(doctor.getName());
            doctor.getPatients().forEach(patient -> System.out.println(patient.getDrugs()));
        });

    }
}
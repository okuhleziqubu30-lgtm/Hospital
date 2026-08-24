/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author User
 */
public class PatientRegistry {
     private final List<Patient> patients;

    public PatientRegistry() {
        patients = new ArrayList<>();
    }

    public void registerPatient(Patient patient) throws DuplicatePatientEcxeption {
        if (searchPatient(patient.getPatientId()) != null) {
            throw new DuplicatePatientEcxeption(
                    "Registration failed: Patient ID '" + patient.getPatientId() + "' is already in use.");
        }
        patients.add(patient);
    }

    public Patient searchPatient(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId().equalsIgnoreCase(patientId)) return p;
        }
        return null;
    }

    public boolean updatePatient(String patientId, String firstName, String lastName,
                                  int age, String gender, String medicalCondition) {
        Patient p = searchPatient(patientId);
        if (p == null) return false;
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        p.setGender(gender);
        p.setMedicalCondition(medicalCondition);
        return true;
    }

    public boolean deletePatient(String patientId) {
        Patient p = searchPatient(patientId);
        if (p == null) return false;
        patients.remove(p);
        return true;
    }

    public List<Patient> getAllPatients() { return patients; }
    public int totalPatients() { return patients.size(); }

    public void sortBySurname() {
        patients.sort(Comparator.comparing(Patient::getLastName, String.CASE_INSENSITIVE_ORDER));
    }

    public void sortByPatientId() {
        patients.sort(Comparator.comparing(Patient::getPatientId, String.CASE_INSENSITIVE_ORDER));
    }

    public void displayAllPatients() {
        System.out.println("\n===================== ALL REGISTERED PATIENTS =====================");
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        for (Patient p : patients) p.displayDetails();
        System.out.println("=====================================================================");
    }
}

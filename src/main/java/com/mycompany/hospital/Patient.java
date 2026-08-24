/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

/**
 *
 * @author User
 */
public class Patient {
     //Core patients attributes, shared by every patient category
    protected String patientId;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String gender;
    protected String medicalCondition;
    protected PatientCategory category;
    
    
    /**
     * Constructs a new Patient with all required attributes.
     *
     * @param patientId        unique identifier for the patient
     * @param firstName        patient's first name
     * @param lastName         patient's last name
     * @param age              patient's age in years
     * @param gender           patient's gender
     * @param medicalCondition short description of the patient's condition
     * @param category         Inpatient, Outpatient, or Emergency
     */
    public Patient(String patientId, String firstName, String lastName, int age, String gender, String medicalCondition, PatientCategory category){
        this.patientId= patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age= age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.category = category;
    }
    
    //Getters and setters
    public String getPatientId(){ return patientId;}
    public String getFirstName(){ return firstName;}
    public void setFirstName(String fistName){this.firstName = firstName;}
    public String getLastName(){ return lastName;}
     public void setLastName(String lastName){this.lastName = lastName;}
    public int getAge(){ return age;}
     public void setAge(int age){this.age= age;}
    public String getGender(){ return gender;}
     public void setGender(String Gender){this.gender = gender;}
    public String getMedicalCondition(){ return medicalCondition;}
     public void setMedicalCondition(String medicalCondition){this.medicalCondition = medicalCondition;}
    public PatientCategory getCategory(){ return category;}

    //Display the patients details to the console
    //Inpatient overrides this method to also display ward and bed
public void displayDetails(){
    System.out.println("-------------------------------------------------------");
    System.out.println("Patient Id:" + patientId);
    System.out.println("Name:" + firstName);
    System.out.println("Name:" + lastName);
    System.out.println("Age:" + age);
    System.out.println("Gender:" + gender);
    System.out.println("Medical Condition:" + medicalCondition);
System.out.println("Category:"+ category);
}

//returns a single line , table-friendly representation of the patient
//inpatient overrides this  to apend ward/bed information
@Override
public String toString(){
    return String.format("%-6s %-12s %-12s %-4d %-8s %-20s %-10s", patientId, firstName,lastName, age, gender, medicalCondition, category);
}
}

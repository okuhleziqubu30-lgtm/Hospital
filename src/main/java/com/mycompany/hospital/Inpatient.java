/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

/**
 *
 * @author User
 */
public class Inpatient extends Patient {
    //attributes specific to inpatiens only
    private int wardNumber;
    private String bedNumber; // e.g. "B01" - null until a bed is assigned

    public Inpatient(String patientId, String firstName, String lastName, int age,
                      String gender, String medicalCondition, int wardNumber) {
        //call the patients constructor toinitailise all inherited attributes
        super(patientId, firstName, lastName, age, gender, medicalCondition, PatientCategory.INPATIENT);
        this.wardNumber = wardNumber;
        this.bedNumber = null;
    }

    public int getWardNumber() { return wardNumber; }
    public void setWardNumber(int wardNumber) { this.wardNumber = wardNumber; }
    public String getBedNumber() { return bedNumber; }
    public void setBedNumber(String bedNumber) { this.bedNumber = bedNumber; }
    public boolean hasBed() { return bedNumber != null; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Ward Number      : " + wardNumber);
        System.out.println("Bed Number       : " + (bedNumber == null ? "Not Allocated" : bedNumber));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Ward:%-4d Bed:%-6s",
                wardNumber, (bedNumber == null ? "None" : bedNumber));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospital;

import java.util.List;
import java.util.Scanner; 

/**
 *
 * @author User
 */
public class Hospital {
private static  Scanner scan = new Scanner(System.in);
private static PatientRegistry registry = new PatientRegistry();
private static Ward ward = new Ward();

    public static void main(String[] args) {
        
     boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> searchPatient();
                case 3 -> updatePatient();
                case 4 -> deletePatient();
                case 5 -> registry.displayAllPatients();
                case 6 -> allocateBed();
                case 7 -> releaseBed();
                case 8 -> ward.displayWardLayout();
                case 9 -> ward.displayAvailableBeds();
                case 10 -> ward.displayOccupiedBeds();
                case 11 -> sortPatients();
                case 12 -> showReports();
                case 0 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scan.close();
    }

    private static void printMenu() {
        System.out.println("\n===== MediCare Hospital Patient Admission System =====");
        System.out.println(" 1. Register a new patient");
        System.out.println(" 2. Search for a patient");
        System.out.println(" 3. Update patient details");
        System.out.println(" 4. Delete a patient");
        System.out.println(" 5. Display all registered patients");
        System.out.println(" 6. Allocate a bed to an inpatient");
        System.out.println(" 7. Release a bed");
        System.out.println(" 8. Display complete ward layout");
        System.out.println(" 9. Display available beds");
        System.out.println("10. Display occupied beds");
        System.out.println("11. Sort patients (surname / patient ID)");
        System.out.println("12. Ward reports");
        System.out.println(" 0. Exit");
    }

    private static void registerPatient() {
        System.out.println("\n-- Register New Patient --");
        String id = readLine("Patient ID: ");
        String first = readLine("First Name: ");
        String last = readLine("Last Name: ");
        int age = readInt("Age: ");
        String gender = readLine("Gender: ");
        String condition = readLine("Medical Condition: ");

        System.out.println("Patient Category: 1) Inpatient  2) Outpatient  3) Emergency");
        int catChoice = readInt("Choose category: ");

        Patient patient;
        if (catChoice == 1) {
            int wardNumber = readInt("Ward Number: ");
            patient = new Inpatient(id, first, last, age, gender, condition, wardNumber);
        } else if (catChoice == 2) {
            patient = new Patient(id, first, last, age, gender, condition, PatientCategory.OUTPATIENT);
        } else {
            patient = new Patient(id, first, last, age, gender, condition, PatientCategory.EMERGENCY);
        }

        try {
            registry.registerPatient(patient);
            System.out.println("Patient registered successfully.");
        } catch (DuplicatePatientEcxeption e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void searchPatient() {
        String id = readLine("\nEnter Patient ID to search: ");
        Patient p = registry.searchPatient(id);
        if (p == null) {
            System.out.println("No patient found with ID: " + id);
        } else {
            p.displayDetails();
        }
    }

    private static void updatePatient() {
        String id = readLine("\nEnter Patient ID to update: ");
        if (registry.searchPatient(id) == null) {
            System.out.println("No patient found with ID: " + id);
            return;
        }
        String first = readLine("New First Name: ");
        String last = readLine("New Last Name: ");
        int age = readInt("New Age: ");
        String gender = readLine("New Gender: ");
        String condition = readLine("New Medical Condition: ");

        boolean updated = registry.updatePatient(id, first, last, age, gender, condition);
        System.out.println(updated ? "Patient updated successfully." : "Update failed.");
    }

    private static void deletePatient() {
        String id = readLine("\nEnter Patient ID to delete: ");
        boolean deleted = registry.deletePatient(id);
        System.out.println(deleted ? "Patient deleted successfully." : "No patient found with ID: " + id);
    }

    private static void sortPatients() {
        System.out.println("Sort by: 1) Surname  2) Patient ID");
        int choice = readInt("Choose: ");
        if (choice == 1) {
            registry.sortBySurname();
        } else {
            registry.sortByPatientId();
        }
        registry.displayAllPatients();
    }

    private static void allocateBed() {
        String id = readLine("\nEnter Patient ID to allocate a bed to: ");
        Patient p = registry.searchPatient(id);
        if (p == null) {
            System.out.println("No patient found with ID: " + id);
            return;
        }
        if (!(p instanceof Inpatient inpatient)) {
            System.out.println("Only Inpatients may be allocated a hospital bed.");
            return;
        }
        if (inpatient.hasBed()) {
            System.out.println("This patient already occupies bed " + inpatient.getBedNumber() + ".");
            return;
        }
        String bedId = readLine("Enter Bed ID to allocate (e.g. B01): ");
        try {
            ward.allocateBed(bedId, inpatient);
            System.out.println("Bed " + bedId + " allocated to " + inpatient.getFirstName() + " " + inpatient.getLastName() + ".");
        } catch (BedUnavailableException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void releaseBed() {
        String bedId = readLine("\nEnter Bed ID to release: ");
        try {
            ward.releaseBed(bedId);
            for (Patient p : registry.getAllPatients()) {
                if (p instanceof Inpatient inpatient && bedId.equalsIgnoreCase(inpatient.getBedNumber())) {
                    inpatient.setBedNumber(null);
                    break;
                }
            }
            System.out.println("Bed " + bedId + " released successfully.");
        } catch (BedUnavailableException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void showReports() {
        List<Patient> all = registry.getAllPatients();
        System.out.println("\n===================== WARD REPORT =====================");
        System.out.println("Total registered patients : " + registry.totalPatients());
        System.out.println("Total occupied beds        : " + ward.getOccupiedBeds().size());
        System.out.println("Total available beds       : " + ward.getAvailableBeds().size());
        System.out.printf("Ward occupancy percentage   : %.1f%%%n", ward.getOccupancyPercentage());
        System.out.println("=========================================================");

        System.out.println("\nView: 1) All patients  2) Available beds  3) Occupied beds  0) Back");
        int choice = readInt("Choose: ");
        switch (choice) {
            case 1 -> registry.displayAllPatients();
            case 2 -> ward.displayAvailableBeds();
            case 3 -> ward.displayOccupiedBeds();
            default -> { }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scan.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Ward {
    public static final int ROWS = 4;
    public static final int COLS = 5;
    public static final int TOTAL_BEDS = ROWS * COLS;

    private final List<Bed> beds;

    public Ward() {
        beds = new ArrayList<>();
        for (int i = 1; i <= TOTAL_BEDS; i++) {
            beds.add(new Bed(String.format("B%02d", i)));
        }
    }

    public void allocateBed(String bedId, Inpatient patient) throws BedUnavailableException {
        if (!hasAvailableBed()) {
            throw new BedUnavailableException("Bed allocation failed: all beds in the ward are occupied.");
        }
        Bed bed = findBed(bedId);
        if (bed == null) {
            throw new BedUnavailableException("Bed allocation failed: bed " + bedId + " does not exist.");
        }
        if (bed.isOccupied()) {
            throw new BedUnavailableException("Bed allocation failed: bed " + bedId + " is already occupied.");
        }
        bed.allocate(patient.getPatientId());
        patient.setBedNumber(bedId);
    }

    public void releaseBed(String bedId) throws BedUnavailableException {
        Bed bed = findBed(bedId);
        if (bed == null) {
            throw new BedUnavailableException("Release failed: bed " + bedId + " does not exist.");
        }
        if (!bed.isOccupied()) {
            throw new BedUnavailableException("Release failed: bed " + bedId + " is already vacant.");
        }
        bed.release();
    }

    public Bed findBed(String bedId) {
        for (Bed bed : beds) {
            if (bed.getBedId().equalsIgnoreCase(bedId)) {
                return bed;
            }
        }
        return null;
    }

    public boolean hasAvailableBed() {
        return getAvailableBeds().size() > 0;
    }

    public List<Bed> getAvailableBeds() {
        List<Bed> available = new ArrayList<>();
        for (Bed bed : beds) {
            if (!bed.isOccupied()) available.add(bed);
        }
        return available;
    }

    public List<Bed> getOccupiedBeds() {
        List<Bed> occupied = new ArrayList<>();
        for (Bed bed : beds) {
            if (bed.isOccupied()) occupied.add(bed);
        }
        return occupied;
    }

    public double getOccupancyPercentage() {
        return (getOccupiedBeds().size() * 100.0) / TOTAL_BEDS;
    }

    public void displayWardLayout() {
        System.out.println("\n=========== WARD LAYOUT (4 x 5) ===========");
        int index = 0;
        for (int r = 0; r < ROWS; r++) {
            StringBuilder row = new StringBuilder();
            for (int c = 0; c < COLS; c++) {
                Bed bed = beds.get(index++);
                String label = bed.isOccupied() ? "[X-" + bed.getBedId() + "]" : "[ " + bed.getBedId() + "]";
                row.append(String.format("%-10s", label));
            }
            System.out.println(row);
        }
        System.out.println("=============================================");
        System.out.println("[ Bxx] = Available    [X-Bxx] = Occupied");
    }

    public void displayAvailableBeds() {
        List<Bed> available = getAvailableBeds();
        System.out.println("\n--- Available Beds (" + available.size() + ") ---");
        if (available.isEmpty()) System.out.println("No beds available.");
        for (Bed bed : available) System.out.println(bed.getBedId());
    }

    public void displayOccupiedBeds() {
        List<Bed> occupied = getOccupiedBeds();
        System.out.println("\n--- Occupied Beds (" + occupied.size() + ") ---");
        if (occupied.isEmpty()) System.out.println("No beds are currently occupied.");
        for (Bed bed : occupied) System.out.println(bed.getBedId() + " -> Patient ID: " + bed.getPatientId());
    }
}

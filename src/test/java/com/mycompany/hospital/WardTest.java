/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.hospital;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class WardTest {
    
    public WardTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
   

    /**
     * Test of allocateBed method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testAllocateBed() throws Exception {
        System.out.println("allocateBed");
        String bedId = "";
        Inpatient patient = null;
        Ward instance = new Ward();
        instance.allocateBed(bedId, patient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of releaseBed method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testReleaseBed() throws Exception {
        System.out.println("releaseBed");
        String bedId = "";
        Ward instance = new Ward();
        instance.releaseBed(bedId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBed method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testFindBed() {
        System.out.println("findBed");
        String bedId = "";
        Ward instance = new Ward();
        Bed expResult = null;
        Bed result = instance.findBed(bedId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasAvailableBed method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testHasAvailableBed() {
        System.out.println("hasAvailableBed");
        Ward instance = new Ward();
        boolean expResult = false;
        boolean result = instance.hasAvailableBed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableBeds method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testGetAvailableBeds() {
        System.out.println("getAvailableBeds");
        Ward instance = new Ward();
        List<Bed> expResult = null;
        List<Bed> result = instance.getAvailableBeds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupiedBeds method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testGetOccupiedBeds() {
        System.out.println("getOccupiedBeds");
        Ward instance = new Ward();
        List<Bed> expResult = null;
        List<Bed> result = instance.getOccupiedBeds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupancyPercentage method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testGetOccupancyPercentage() {
        System.out.println("getOccupancyPercentage");
        Ward instance = new Ward();
        double expResult = 0.0;
        double result = instance.getOccupancyPercentage();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayWardLayout method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testDisplayWardLayout() {
        System.out.println("displayWardLayout");
        Ward instance = new Ward();
        instance.displayWardLayout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAvailableBeds method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testDisplayAvailableBeds() {
        System.out.println("displayAvailableBeds");
        Ward instance = new Ward();
        instance.displayAvailableBeds();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayOccupiedBeds method, of class Ward.
     */
    @org.junit.jupiter.api.Test
    public void testDisplayOccupiedBeds() {
        System.out.println("displayOccupiedBeds");
        Ward instance = new Ward();
        instance.displayOccupiedBeds();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

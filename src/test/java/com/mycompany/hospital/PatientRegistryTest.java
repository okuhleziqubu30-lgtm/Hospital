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
public class PatientRegistryTest {
    
    public PatientRegistryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registerPatient method, of class PatientRegistry.
     */
    @Test
    public void testRegisterPatient() throws Exception {
        System.out.println("registerPatient");
        Patient patient = null;
        PatientRegistry instance = new PatientRegistry();
        instance.registerPatient(patient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPatient method, of class PatientRegistry.
     */
    @Test
    public void testSearchPatient() {
        System.out.println("searchPatient");
        String patientId = "";
        PatientRegistry instance = new PatientRegistry();
        Patient expResult = null;
        Patient result = instance.searchPatient(patientId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePatient method, of class PatientRegistry.
     */
    @Test
    public void testUpdatePatient() {
        System.out.println("updatePatient");
        String patientId = "";
        String firstName = "";
        String lastName = "";
        int age = 0;
        String gender = "";
        String medicalCondition = "";
        PatientRegistry instance = new PatientRegistry();
        boolean expResult = false;
        boolean result = instance.updatePatient(patientId, firstName, lastName, age, gender, medicalCondition);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePatient method, of class PatientRegistry.
     */
    @Test
    public void testDeletePatient() {
        System.out.println("deletePatient");
        String patientId = "";
        PatientRegistry instance = new PatientRegistry();
        boolean expResult = false;
        boolean result = instance.deletePatient(patientId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPatients method, of class PatientRegistry.
     */
    @Test
    public void testGetAllPatients() {
        System.out.println("getAllPatients");
        PatientRegistry instance = new PatientRegistry();
        List<Patient> expResult = null;
        List<Patient> result = instance.getAllPatients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalPatients method, of class PatientRegistry.
     */
    @Test
    public void testTotalPatients() {
        System.out.println("totalPatients");
        PatientRegistry instance = new PatientRegistry();
        int expResult = 0;
        int result = instance.totalPatients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortBySurname method, of class PatientRegistry.
     */
    @Test
    public void testSortBySurname() {
        System.out.println("sortBySurname");
        PatientRegistry instance = new PatientRegistry();
        instance.sortBySurname();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByPatientId method, of class PatientRegistry.
     */
    @Test
    public void testSortByPatientId() {
        System.out.println("sortByPatientId");
        PatientRegistry instance = new PatientRegistry();
        instance.sortByPatientId();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllPatients method, of class PatientRegistry.
     */
    @Test
    public void testDisplayAllPatients() {
        System.out.println("displayAllPatients");
        PatientRegistry instance = new PatientRegistry();
        instance.displayAllPatients();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

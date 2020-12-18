/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sachini
 */
public class Service_and_repair_reportTest {
    
    public Service_and_repair_reportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of userList method, of class Service_and_repair_report.
     */
    @Test
    public void testUserList() {
        System.out.println("userList");
        Service_and_repair_report instance = new Service_and_repair_report();
        ArrayList<RepairReport> expResult = null;
        ArrayList<RepairReport> result = instance.userList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of show_user method, of class Service_and_repair_report.
     */
    @Test
    public void testShow_user() {
        System.out.println("show_user");
        Service_and_repair_report instance = new Service_and_repair_report();
        instance.show_user();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Service_and_repair_report.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Service_and_repair_report.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getsum method, of class Service_and_repair_report.
     */
    @Test
    public void testGetsum() {
        System.out.println("getsum");
        Service_and_repair_report instance = new Service_and_repair_report();
        double expResult = 0.0;
        double result = instance.getsum();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

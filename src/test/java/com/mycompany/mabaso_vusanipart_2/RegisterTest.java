/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mabaso_vusanipart_2;

import com.mycompany.mabaso_vusani_part_2.Register;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author RC_Student_lab
 */
public class RegisterTest {
    
    public RegisterTest() {
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
     * Test of checkUserName method, of class Register.
     */
    @Test
    public void testCheckUserNameSuccess() {
        System.out.println("checkUserNameSuccess");
        Register registration = new Register();
        boolean expResult = true;
        boolean result = registration.checkUserName("kyl_1");
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckUserNameFail() {
        System.out.println("checkUserNameFail");
        Register registration = new Register();
        boolean expResult = false;
        boolean result = registration.checkUserName("kyle!!!!!!!");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkPasswordComplexity method, of class Register.
     */
    @Test
    public void testCheckPasswordComplexityFail() {
        System.out.println("checkPasswordComplexityFail");
        Register instance = new Register();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity("kyle!!!!!!!");
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckPasswordComplexitySucess() {
        System.out.println("checkPasswordComplexitySuccess");
        Register instance = new Register();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity("Ch&&sec@ke99!");
        assertEquals(expResult, result);
    }
    /**
     * Test of registerUser method, of class Register.
     */
    @Test
    public void testRegisterUserSucess() {
        System.out.println("registerUserSuccess");
        Register instance = new Register();
        String expResult = "User has been registered successfully";
        String result = instance.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterUserFail() {
        System.out.println("registerUserFail");
        Register instance = new Register();
        String expResult = "Password is not correctly formatted, please ensure "
                + "that the password contains at least 8 characters, a capital "
                + "letter, a number and a special character.";
        String result = instance.registerUser("kyl_1", "password");
        assertEquals(expResult, result);
    }
}
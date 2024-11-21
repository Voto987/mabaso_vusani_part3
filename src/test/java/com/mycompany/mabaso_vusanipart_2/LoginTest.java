/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mabaso_vusanipart_2;

import org.junit.jupiter.api.Test;

/**
 *
 * @author RC_Student_lab
 */
class Login {

    String returnLoginStatus(String registerUsername, String loginUsername, String registerPassword, String loginPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean loginUser(String registerUsername, String loginUsername, String registerPassword, String loginPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
public class LoginTest {
    
    public LoginTest() {
    }
      
    @Test
    public void testReturnLoginStatusSuccess() {
    System.out.println("testReturnLoginStatusSuccess");
    String loginPassword = "Ch&&sec@ke99!";
    String registerPassword = "Ch&&sec@ke99!";
    String loginUsername = "kyl_1";
    String registerUsername = "kyl_1";
    
    Login login = new Login();
    String expectedResult = "Welcome " + registerUsername + " , " + registerPassword + 
             "it is great to see you again";
    String result = login.returnLoginStatus(registerUsername, loginUsername,
            registerPassword, loginPassword);
    assertEquals(expectedResult, result); 
    }

    @Test
    public void testReturnLoginStatusFail() {
    System.out.println("testReturnLoginStatusFail");
    String loginPassword = "Ch&&sec@ke99!";
    String registerPassword = "Ch&&sec@ke99!";
    String loginUsername = "kyl_1";
    String registerUsername = "kyl_10";
    
    Login login = new Login();
    String expectedResult = "Username or password incorrect, please try again";
    String result = login.returnLoginStatus(registerUsername, loginUsername,
            registerPassword, loginPassword);
    assertEquals(expectedResult, result); 
    }
    
    @Test
    public void loginUserFail(){
    System.out.println("loginUserFail");
    String loginPassword = "Ch&&sec@ke99!";
    String registerPassword = "Ch&&sec@ke99!";
    String loginUsername = "kyl_1";
    String registerUsername = "kyl_10";
    
    Login login = new Login();
    boolean expectedResult = false;
    boolean result = login.loginUser(registerUsername, loginUsername,
            registerPassword, loginPassword);
    assertEquals(expectedResult, result);    
    }
    
    @Test
    public void loginUserSuccess(){
    System.out.println("loginUserSuccess");
    String loginPassword = "Ch&&sec@ke99!";
    String registerPassword = "Ch&&sec@ke99!";
    String loginUsername = "kyl_1";
    String registerUsername = "kyl_1";
    
    Login login = new Login();
    boolean expectedResult = true;
    boolean result = login.loginUser(registerUsername, loginUsername,
            registerPassword, loginPassword);
    assertEquals(expectedResult, result);    
    }    

    private void assertEquals(boolean expectedResult, boolean result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String expectedResult, String result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
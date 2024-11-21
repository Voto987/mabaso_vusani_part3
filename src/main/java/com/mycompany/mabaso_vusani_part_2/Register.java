/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mabaso_vusani_part_2;

/**
 *
 * @author RC_Student_lab
 */
public class Register {
 private String username;
 private String password;
 private String firstName;
 private String lastName;
 
 
 public void setUsername(String username){
     this.username = username;
 }
 public String getUsername(){
    return this.username;
 }
 
 public void setPassword(String password){
     this.password = password;
 }
 public String getPassword(){
    return this.password;
    
 }
 
 public void setFirstName(String firstName){
     this.firstName = firstName;
 }
 public String getFirstName(){
    return this.firstName;
 }

 public void setLastName(String lastName){
     this.lastName = lastName;
 }
 public String getLastName(){
    return this.lastName;
} 
/*
   Check if username meets requires:
   1) Contains an underscore
   2) The username has no more than 5 characters
   */
 public boolean checkUserName(String input){       
    if(input.contains("_") || input.length()<=5){
        return true;
    }else{            
        return false;
    }
}
 
    public boolean checkPasswordComplexity(String input){
        boolean hasUpperCase = checkUpperCase(input);
        boolean hasNumber = checkNumber(input);
        boolean hasSpecialChars = checkSpecialChars(input);
        if(input.length()>=8 && hasUpperCase&& hasNumber && hasSpecialChars){
            return true;
        }
        return false;
    }
    
    private boolean checkUpperCase(String input){
        for(int i = 0; i < input.length(); i++){
            if(Character.isUpperCase(input.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private boolean checkNumber(String input){
        for(int i = 0; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
                return true;
            }
        }
        return false;
    }    
    
    private boolean checkSpecialChars(String input){
        String specialChars = "`~!@#$%^&*()_./-+={}|?;':<>,";
        for(int i = 0; i < input.length(); i++){
            if(specialChars.contains(String.valueOf(input.charAt(i)))){
                return true;
            }
        }
        return false;
    } 
    
    
        public String registerUser(String username, String password){
        String status = null;
        if(!checkUserName(username)){
            status = "Username is not correctly formatted, please ensure that "
                    + "your username contains an underscore and is no more than"
                    + " 5 characters in length";
        }
        
        if(!checkPasswordComplexity(password)){
            status = "Password is not correctly formatted, please ensure that the"
                    + " password contains at least 8 characters, a capital "
                    + "letter, a number and a special character.";
        }
        if(checkUserName(username) && checkPasswordComplexity(password)){
            status = "User has been registered successfully";
        }
        return status;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mabaso_vusani_part_2;

/**
 *
 * @author NoahC
 */
public class Login {
 private String username;
 private String password;

 
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
 
public boolean loginUser(String registerUsername, String loginUsername,
        String registerPassword, String loginPassword ){
   if(registerUsername.equals(loginUsername) && 
           registerPassword.equals(loginPassword)){
       return true;        
   } else{
       return false;
   }
}

public String returnLoginStatus(String registerUsername, String loginUsername,
             String registerPassword, String loginPassword){
     if(loginUser(registerUsername, loginUsername,registerPassword, loginPassword )){
     return "Welcome " + registerUsername + " , " + registerPassword + 
             "it is great to see you again";
     } else {
         return "Username or password incorrect, please try again";
     }
    }
 
}



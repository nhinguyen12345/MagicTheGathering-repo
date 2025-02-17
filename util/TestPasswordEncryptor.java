package util;


import util.PasswordEncryptor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nhinguyen
 */
public class TestPasswordEncryptor {
    public static void main(String [] args){
        
        String pass2 = "98765";
       
      
         System.out.println(PasswordEncryptor.encryptPassword(pass2));
         
    }
}

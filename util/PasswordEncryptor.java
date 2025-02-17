/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhinguyen
 */
public class PasswordEncryptor {
    public static String encryptPassword(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] cipherBytes = md.digest(password.getBytes());
            password = Base64.getEncoder().encodeToString(cipherBytes);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }
}

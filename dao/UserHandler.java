/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import bo.CardSet;
import bo.UserProfile;
import util.SQLUtil;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.PasswordEncryptor;
/**
 *
 * @author nhinguyen
 */
public class UserHandler {
    private SQLUtil sqlUtil;
    public UserHandler(){
        sqlUtil = new SQLUtil();
}
    public UserProfile login(String username, String password){
        UserProfile user = null;
    
        
            //password = PasswordEncryptor.encryptPassword(password);
            String cmd = String.format("select UserId, Username, UserPassword from UserProfile where UserName = '%s' and UserPassword = '%s'", username, password);
            ResultSet rs = sqlUtil.executeQuery(cmd);
        try{
            if(rs.next()){
               int UserId = rs.getInt("UserId");
               String Password = rs.getString("UserPassword");
               String pass = PasswordEncryptor.encryptPassword(Password);
               String Username = rs.getString("UserName");
               user = new UserProfile(UserId,Username, pass);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }
    public List<UserProfile> getUser(){
       
            List<UserProfile> users = new ArrayList<>();
            String cmd = "select * from UserProfile;";
            ResultSet rs = sqlUtil.executeQuery(cmd);
            try {
                while(rs.next()){
                    int UserId = rs.getInt("UserId");
                    String UserName = rs.getString("UserName");
                    String Password = rs.getString("UserPassword");
                    UserProfile s = new UserProfile(UserId,UserName,Password);
                    users.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
               return users;
    }

    }
    

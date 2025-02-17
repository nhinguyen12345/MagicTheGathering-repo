/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import bo.CardSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.SQLUtil;
/**
 *
 * @author nhinguyen
 */
public class SetHandler {
    private SQLUtil sqlUtil;
    
    public SetHandler(){
        sqlUtil = new SQLUtil();
    }
    
    public List<CardSet> getSet(){
       
            List<CardSet> results = new ArrayList<>();
            String cmd = "select SetId, SetName from CardSet";
            ResultSet rs = sqlUtil.executeQuery(cmd);
            try {
                while(rs.next()){
                    int SetId = rs.getInt("SetId");
                    String SetName = rs.getString("SetName");
                    CardSet s = new CardSet(SetId,SetName);
                    results.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
               return results;
    }
    //private int setId;
    //private String SetName;
}

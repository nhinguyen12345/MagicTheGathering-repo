/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.CardCollection;

import java.util.ArrayList;
import java.util.List;
import util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhinguyen
 */
public class CollectionHandler {
    private SQLUtil sqlUtil;

    public CollectionHandler() {
        sqlUtil = new SQLUtil();
    }
    public List<CardCollection> getCollection(){
        List<CardCollection> results = new ArrayList<>();
        String cmd = "select CollectionID, CardId, UserID, Quantity, cm.CardName from CardCollection cc join CardMarket cm on cc.CardId = cm.CardId;";;
        ResultSet rs = sqlUtil.executeQuery(cmd);
        
        try {
            while(rs.next()){
                int quantity = rs.getInt("Quantity");
                int ColID = rs.getInt("CollectionID");
                int CardID = rs.getInt("CardId");
                int UserID = rs.getInt("UserID");
                String CardName = rs.getString("CardName");
                CardCollection c = new CardCollection(ColID,CardID, UserID, quantity, CardName);
                results.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CollectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return results;
    }
    public int AddCardtoCollection(int CollectionId, int CardId, int UserId, int quantity){
        String cmdTemplate = "insert into CardCollection(CollectionId, CardId, UserId, quantity) values(%d,%d,%d,%d);";
        String cmd = String.format(cmdTemplate, CollectionId, CardId, UserId, quantity);
        return sqlUtil.executeUpdate(cmd);
}
    public int updateCard(int CollectionId, int CardId,  int UserId, int quantity,String CardName){
        String cmdTemplate = "update CardCollection set CollectionId = %d, CardId = %d , UserId = %d, quantity = %d where CardId = %d;";
        String cmd = String.format(cmdTemplate, CollectionId, CardId, UserId, quantity);
        return sqlUtil.executeUpdate(cmd);
    }
      public List<CardCollection> loadCardCollection(String keyword) throws SQLException{
        List<CardCollection> collections = new ArrayList<>();
        String cmdTemplate = "select CollectionId, cc.CardId, UserId, quantity, cm.CardName from CardCollection cc join CardMarket cm on cm.CardID = cc.CardId where cm.CardName like '%s' ; ";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try{
            while(rs.next()){
                int CollectionId = rs.getInt("CollectionId");
                int CardId = rs.getInt("CardId");
                int UserId  = rs.getInt("UserId");
                int quantity = rs.getInt("quantity");
                String CardName = rs.getString("CardName");
                CardCollection CardCollection = new CardCollection(CollectionId, CardId, UserId, quantity, CardName);
                collections.add(CardCollection);
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(SQLUtil.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
        return collections;
    }
       public int deleteCard(int CollectionId){
        String cmdTemplate = "delete from CardCollection where CollectionId = %d";
        String cmd = String.format(cmdTemplate, CollectionId);
        return sqlUtil.executeUpdate(cmd);
}
}

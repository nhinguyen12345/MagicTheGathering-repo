/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import bo.CardMarket;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nhinguyen
 */
public class CardMarketHandler {
    private SQLUtil sqlUtil;
    public CardMarketHandler() {
        sqlUtil = new SQLUtil();
    }
    public int AddCardtoMarket(int CardId, String CardName,  String color, String type, Double cost, int SetId){
        String cmdTemplate = "insert into CardMarket(CardId, CardName, color, Cardtype, cost, SetId) values(%d,'%s','%s', '%s',%f,%d);";
        String cmd = String.format(cmdTemplate, CardId, CardName, type, color, cost, SetId);
        return sqlUtil.executeUpdate(cmd);
    }
    public int deleteCard(int CardId){
        String cmdTemplate = "delete from CardMarket where CardId = %d";
        String cmd = String.format(cmdTemplate, CardId);
        return sqlUtil.executeUpdate(cmd);
    }
    public int updateCard(int CardId, String CardName,  String color, String type, Double cost, int SetId){
        String cmdTemplate = "update CardMarket set CardName = '%s', color = '%s', CardType = '%s', cost = %.2f, SetId = %d where CardId = %d;";
        String cmd = String.format(cmdTemplate, CardName, color, type, cost, SetId, CardId);
        return sqlUtil.executeUpdate(cmd);
    }
    public List<CardMarket> loadCardMarket(String keyword) throws SQLException{
        List<CardMarket> cards = new ArrayList<>();
        String cmdTemplate = "select CardId, CardName, color, Cardtype, cost, SetId from CardMarket where CardName like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try{
            while(rs.next()){
                int CardId = rs.getInt("CardId");
                String CardName = rs.getString("CardName");
                String color = rs.getString("color");
                String CardType = rs.getString("CardType");
                double cost = rs.getDouble("cost");
                int SetId = rs.getInt("SetId");
                CardMarket CardMarket = new CardMarket(CardId, CardName, color, CardType, cost, SetId);
                cards.add(CardMarket);
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(SQLUtil.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
        return cards;
    }
    public List<CardMarket> getCard(){
       
            List<CardMarket> cards = new ArrayList<>();
            String cmd = "select * from CardMarket;";
            ResultSet rs = sqlUtil.executeQuery(cmd);
            try {
                while(rs.next()){
                int CardId = rs.getInt("CardId");
                String CardName = rs.getString("CardName");
                String color = rs.getString("color");
                String CardType = rs.getString("CardType");
                double cost = rs.getDouble("cost");
                int SetId = rs.getInt("SetId");
                CardMarket CardMarket = new CardMarket(CardId, CardName, color, CardType, cost, SetId);
                cards.add(CardMarket);
            }
        } catch (SQLException ex) {
           java.util.logging.Logger.getLogger(SQLUtil.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
               return cards;
    }
}


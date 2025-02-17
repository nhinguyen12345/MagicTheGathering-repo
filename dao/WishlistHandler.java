/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bo.CardCollection;
import bo.Wishlist;
import java.sql.ResultSet;
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
public class WishlistHandler {
    private SQLUtil sqlUtil;

    public WishlistHandler() {
        sqlUtil = new SQLUtil();
    }
    public List<Wishlist> getWishlist(){
        List<Wishlist> wishlists = new ArrayList<>();
        String cmd = "select UserID, CardId, RankPreference from Wishlist;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        
        try {
            while(rs.next()){
                String RP = rs.getString("RankPreference");
                int CardID = rs.getInt("CardId");
                int UserID = rs.getInt("UserID");
                
                Wishlist w = new Wishlist( UserID, CardID, RP);
                wishlists.add(w);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WishlistHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return wishlists;
    }
    public int AddCardtoWishList(int UserId, int CardId, String RP){
        String cmdTemplate = "insert into WishList(UserId, CardId, RankPreference) values(%d,%d,'%s');";
        String cmd = String.format(cmdTemplate, UserId, CardId, RP);
        return sqlUtil.executeUpdate(cmd);
}
    public int updateCard(int UserId, int CardId, String RP){
        String cmdTemplate = "update Wishlist set UserId = %d, CardId = %d , RankPreference = '%s' where RankPreference = '%s';";
        String cmd = String.format(cmdTemplate,UserId, CardId, RP);
        return sqlUtil.executeUpdate(cmd);
    }
      public List<Wishlist> loadWishlist(String keyword) throws SQLException{
        List<Wishlist> wl = new ArrayList<>();
        String cmdTemplate = "select UserId, CardId, RankPreference from Wishlist where RankPreference like '%s' ; ";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try{
            while(rs.next()){
                
                int CardId = rs.getInt("CardId");
                int UserId  = rs.getInt("UserId");
                
                String RP = rs.getString("RankPreference");
                Wishlist w = new Wishlist(UserId, CardId, RP);
                wl.add(w);
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(SQLUtil.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
        return wl;
    }
       public int deleteCard(int UserId){
        String cmdTemplate = "delete from Wishlist where UserId = %d";
        String cmd = String.format(cmdTemplate, UserId);
        return sqlUtil.executeUpdate(cmd);
}
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.Vector;

/**
 *
 * @author nhinguyen
 */
public class Wishlist {
    int UserId;
    int CardId;
    String RankPreference;   

    public Wishlist(int UserId, int CardId, String RankPreference) {
        this.UserId = UserId;
        this.CardId = CardId;
        this.RankPreference = RankPreference;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getCardId() {
        return CardId;
    }

    public void setCardId(int CardId) {
        this.CardId = CardId;
    }

    public String getRankPreference() {
        return RankPreference;
    }

    public void setRankPreference(String RankPreference) {
        this.RankPreference = RankPreference;
    }
    
    public Vector getRow(){
        Vector vec = new Vector();
        vec.add(this.UserId);
        vec.add(this.CardId);
        vec.add(this.RankPreference);
      
        return vec;
    }

    
}



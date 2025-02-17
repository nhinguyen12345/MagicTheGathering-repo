package dao;

import bo.UserDeck;
import util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDeckHandler {
    private SQLUtil sqlUtil;

    public UserDeckHandler() {
        sqlUtil = new SQLUtil();
    }

    public int addUserDeck(int DeckId, String DeckName, int UserId) {
        String cmdTemplate = "insert into UserDecks(DeckId, DeckName, UserId) values(%d, '%s', %d);";
        String cmd = String.format(cmdTemplate, DeckId, DeckName, UserId);
        return sqlUtil.executeUpdate(cmd);
    }

    public int deleteUserDeck(int DeckId) {
        String cmdTemplate = "delete from UserDecks where DeckId = %d";
        String cmd = String.format(cmdTemplate, DeckId);
        return sqlUtil.executeUpdate(cmd);
    }

    public int updateUserDeck(int DeckId, String DeckName, int UserId) {
        String cmdTemplate = "update UserDecks set DeckName = '%s', UserId = %d where DeckId = %d;";
        String cmd = String.format(cmdTemplate, DeckName, UserId, DeckId);
        return sqlUtil.executeUpdate(cmd);
    }

    public List<UserDeck> loadUserDecks(String keyword) throws SQLException {
        List<UserDeck> decks = new ArrayList<>();
        String cmdTemplate = "select DeckId, DeckName, UserId from UserDecks where DeckName like '%s'";
        String cmd = String.format(cmdTemplate, "%" + keyword + "%");
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                int DeckId = rs.getInt("DeckId");
                String DeckName = rs.getString("DeckName");
                int UserId = rs.getInt("UserId");
                UserDeck deck = new UserDeck(DeckId, DeckName, UserId);
                decks.add(deck);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(SQLUtil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return decks;
    }

    public List<UserDeck> getUserDecks() {
        List<UserDeck> decks = new ArrayList<>();
        String cmd = "select * from UserDeck;";
        ResultSet rs = sqlUtil.executeQuery(cmd);
        try {
            while (rs.next()) {
                int DeckId = rs.getInt("DeckId");
                String DeckName = rs.getString("DeckName");
                int UserId = rs.getInt("UserId");
                UserDeck deck = new UserDeck(DeckId, DeckName, UserId);
                decks.add(deck);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(SQLUtil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return decks;
    }
}

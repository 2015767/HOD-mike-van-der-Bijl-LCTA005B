package nl.hva.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.hva.web.connection.MyDBConnection;
import nl.hva.web.model.User;

public class UserDAO {

    MyDBConnection connection = new MyDBConnection();

    public UserDAO() {
        // initialization 
    }

    public List<User> findAll() {
        List<User> list = new LinkedList<User>();
        try {
            connection.startConnection();

            String query = "SELECT * FROM USER";

            PreparedStatement pstmt = connection.getConnection().prepareStatement(query);

            ResultSet rs = connection.performSelect(pstmt);

            while (rs.next()) {
                User tempUserData = new User();
                tempUserData.setUserId(rs.getInt("userID"));
                tempUserData.setFirstName(rs.getString("firstname"));
                tempUserData.setLastName(rs.getString("lastname"));
                tempUserData.seteMail(rs.getString("eMail"));

                list.add(tempUserData);
            }

            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<User> findByLastName(String lastname) {
        List<User> list = new LinkedList<User>();
        try {
            connection.startConnection();

            // BAD SQL: injection
            // String query = "SELECT * FROM USER WHERE LASTNAME= '"+lastname+ "'";
            // ALL SQL should be parametrized
            String query = "SELECT * FROM User WHERE lastname= ? ";

            PreparedStatement pstmt = connection.getConnection().prepareStatement(query);
            pstmt.setString(1, lastname);

            ResultSet rs = connection.performSelect(pstmt);

            while (rs.next()) {
                User tempUserData = new User();
                tempUserData.setUserId(rs.getInt("userID"));
                tempUserData.setFirstName(rs.getString("firstname"));
                tempUserData.setLastName(rs.getString("lastname"));
                tempUserData.seteMail(rs.getString("eMail"));

                list.add(tempUserData);
            }

            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public User findById(int userId) {
        User tempUserData = new User();
        try {
            connection.startConnection();

            String query = "SELECT * FROM User WHERE userID= ? ";

            PreparedStatement pstmt = connection.getConnection().prepareStatement(query);
            pstmt.setInt(1, userId);

            ResultSet rs = connection.performSelect(pstmt);

            while (rs.next()) {

                tempUserData.setUserId(rs.getInt("userID"));
                tempUserData.setFirstName(rs.getString("firstname"));
                tempUserData.setLastName(rs.getString("lastname"));
                tempUserData.seteMail(rs.getString("eMail"));

            }

            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tempUserData;
    }

    public long insert(User user) {
        try {
            connection.startConnection();

            String query = "INSERT INTO USER (firstname, lastname, email)"
                    + " VALUES (?,?,?) ";

            PreparedStatement pstmt = connection.getConnection().prepareStatement(query);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.geteMail());

            //pstmt.executeUpdate();
            connection.performUpdate(pstmt);

            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public long update(User user) {

        try {
            connection.startConnection();

            String query = "UPDATE USER SET "
                    + "firstname= ? ,"
                    + "lastname = ? ,"
                    + "email= ? "
                    + " WHERE userID= ?";

            PreparedStatement pstmt = connection.getConnection().prepareStatement(query);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.geteMail());
            pstmt.setInt(4, user.getUserId());
            //pstmt.executeUpdate();
            connection.performUpdate(pstmt);

            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public long remove(User user) {
        try {
            connection.startConnection();

            String query = "DELETE FROM USER "
                    + " WHERE userID= ?";

            PreparedStatement pstmt = connection.getConnection().prepareStatement(query);
            pstmt.setInt(1, user.getUserId());
            //pstmt.executeUpdate();
            connection.performUpdate(pstmt);

            connection.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public int removeAll() {
        int numbRowsDeleted = 0;

        return numbRowsDeleted;
    }
}

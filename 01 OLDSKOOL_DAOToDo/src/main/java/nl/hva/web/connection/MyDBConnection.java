package nl.hva.web.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ahmed
 */
public class MyDBConnection {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost/web_oldskool_dao";
    private static final String DBUSER = "root";
    private static final String DBPASS = "admin";

    private ResultSet result = null;
    private int affectedRows = -1;
    Connection conn = null;

    public MyDBConnection() {
    }

    public void startConnection() {
        try {

            Class.forName(DRIVER);

            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        conn = null;
    }

    public ResultSet performSelect(PreparedStatement query) {
        try {
            result = query.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int performUpdate(PreparedStatement pstmt) {
        try {
            affectedRows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public Connection getConnection() {
        return conn;
    }
}

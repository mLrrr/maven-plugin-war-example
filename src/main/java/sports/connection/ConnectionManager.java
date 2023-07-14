package sports.connection;


 

import java.sql.*;

public class ConnectionManager {
    private static Connection con;
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "sportseq";
    private static final String DB_PASSWORD = "sportseq";
    
    public static Connection getConnection() {

        try {
        	//1. load the driver
            Class.forName(DB_DRIVER);

            try {
            	//2. create connection
                con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                System.out.println("connected");
            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}

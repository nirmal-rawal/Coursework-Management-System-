package course;




import java.sql.*;

public class DataConn {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            System.out.println("Connecting to the database...");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            // System.out.println(conn);
            
            // Check if the connection is successful
            if (conn != null) {
                System.out.println("Database connection is successful!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}

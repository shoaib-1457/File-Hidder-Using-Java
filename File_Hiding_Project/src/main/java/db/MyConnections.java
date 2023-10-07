package db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnections {
    public static Connection connection = null;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filehiddingproject?uSSL=false","root","123456");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Conection Check");
        return connection;
    }
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}

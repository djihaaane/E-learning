package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection{


           String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
            String user = "root";
            String passwd = "Djihane_9";
        private static Connection conn;
    private connection(){
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getInstance(){
        if(conn == null){
            new connection();
        }
        return conn;
    }

}
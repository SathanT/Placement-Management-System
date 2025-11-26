package src.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnections {
    private static final String url="";
    private static final String user="";
    private static final String password="";

    private DatabaseConnections(){}

    public static Connection getConnection(){
        Connection conn=null;
        try{
            conn=DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
            System.out.print("Connection failed"+e.getMessage());
        }
        return conn;
    }
}



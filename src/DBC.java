import java.sql.*;
public class DBC 
{
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER ="root";
    private static final String PASSWORD="";

    public static Connection getConnection()
     {
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
            return null;
        } 
    }
}


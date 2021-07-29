package quizapplication;
import java.sql.*;
public class DBConnection 
{
    static final String DB_URL ="jdbc:mysql://localhost:3306/quiz";
    static final String USER="root";
    static final String PASS="2001";
    public static Connection connectDB()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
         
    }
}

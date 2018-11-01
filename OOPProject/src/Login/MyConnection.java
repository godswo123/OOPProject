package Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection 
{
	private static Connection connection;
	private static Statement statement;
	public static boolean getConnection()
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			statement = connection.createStatement();
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		if(connection!=null)
			return true;
		else
			return false;
	}
	
	public static ResultSet executeQuery(String query)
	{
		ResultSet rsResultSet = null;
		try {
			rsResultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsResultSet;
	}
	
	public static void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateQuery(String query)
	{
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

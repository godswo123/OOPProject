package Login;
import java.sql.*;

public class User 
{
	public static boolean login(String username, String password)
	{	
		if(MyConnection.getConnection())
		{
			String query = "select password from userinfo where username = '"+username+"'";
			ResultSet rSet = MyConnection.executeQuery(query);
			try
			{
				if(rSet.next())
				{
					if(rSet.getString(1).equals(password))
						return true;
					else
						return false;
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occured");
			}
			finally {
				MyConnection.closeConnection();
			}
		}
		return false;
		
	}
	
	public static void register(String Name, String DOB, String emailid, String username, String password,String Address)
	{
		
		MyConnection.getConnection();
		String query = "INSERT INTO userinfo (`name`, `dob`, `address`, `emailid`, `username`, `password`)"
					  +"VALUES ('"+Name+"', '"+DOB+"', '"+Address+"', '"+emailid+"', '"+username+"', '"+password+"')";
		MyConnection.updateQuery(query);
		MyConnection.closeConnection();
	}
	
	
	public static boolean checkAvailability(String username)
	{
		MyConnection.getConnection();
		String query = "select username from userinfo where username = '"+username+"'";
		ResultSet rSet = MyConnection.executeQuery(query);
		try {
			if(rSet.next())
				return false;
			else
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			MyConnection.closeConnection();
		}
		return false;
	}
	
}

package Login;
import java.sql.*;

public class User 
{
	public static boolean login(String username, String password)
	{	
		if(MyConnection.getConnection())
		{
			String query = "select Password from userinfo where UserName = '"+username+"'";
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
	
	public static int register(String name, Date DOB, String Add, String Email, String UName, String OrPass,String RePass)
	{
		
		MyConnection.getConnection();
		try
		{
			
			String query = "SELECT Password FROM userinfo WHERE UserName='"+UName+"'";
			ResultSet rs = MyConnection.executeQuery(query);
			
			
			if(name.equals("")||Add.equals("")||Email.equals("")||UName.equals("")||OrPass.equals("")||RePass.equals(""))
			{
				return 0;
			}
			
			else if(rs.next())
			{
				return 1;
			}
			
			else if(!(OrPass.equals(RePass)))
			{
				return 2;
			}
			else
			{
				String qry1="INSERT INTO userinfo VALUES('"+name+"','"+DOB+"','"+Add+"','"+Email+"','"+UName+"','"+OrPass+"')" ;
				MyConnection.updateQuery(qry1);
				return 3;
			}
			
		}catch(Exception e)
		{
			return 0;
		}
		finally {
			MyConnection.closeConnection();
		}
		
	}
	
	
	public static boolean checkAvailability(String username)
	{
		
		for(int i=0;i<username.length();i++)
		{
			if(!(((username.charAt(i)>='A'&&username.charAt(i)<='Z')||(username.charAt(i)>='a'&&username.charAt(i)<='z'))||(username.charAt(i)>='0'&&username.charAt(i)<='9')))
			{
				return false;
			}
		}
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
			//e.printStackTrace();
		}
		finally {
			MyConnection.closeConnection();
		}
		return false;
	}
	
	public static String findName(String username)
	{
		
		MyConnection.getConnection();
		String query = "select name from userinfo where username = '"+username+"'";
		ResultSet rs = MyConnection.executeQuery(query);
		try
		{
			if(rs.next())
			return rs.getString(1);
			else return null; 
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			return "ptr";
		}
		finally {
			MyConnection.closeConnection();
		}

	}
	
	public static int updateInfo(String name, Date DOB, String Add, String Email, String UName, String OPass, String NPass)
	{
		MyConnection.getConnection();
		try
		{
			
			String query = "SELECT Password FROM userinfo WHERE UserName='"+UName+"'";
			ResultSet rs = MyConnection.executeQuery(query);
			String password = "";
			if(rs.next())
			{
				password = rs.getString(1);
			}
			if(name.equals("")||Add.equals("")||Email.equals("")||UName.equals("")||NPass.equals(""))
			{
				return 0;
			}
			else if(!password.equals(OPass))
			{
				return 1;
			}
			else
			{
				String qry1="UPDATE userinfo SET name = '"+name+"', dob = '"+DOB+"', address = '"+Add+"', emailid = '"+Email+"', password = '"+NPass+"'";
				MyConnection.updateQuery(qry1);
				return 2;
			}
			
		}catch(Exception e)
		{
			return 0;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static void removeAccount(String username)
	{
		MyConnection.getConnection();
		String query = "UPDATE userinfo SET password = 'removed' where username ='"+username+"'";
		MyConnection.updateQuery(query);
		MyConnection.closeConnection();
	}
	
}

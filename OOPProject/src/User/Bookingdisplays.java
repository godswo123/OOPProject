package User;
import Login.*;
import java.sql.ResultSet;

public class Bookingdisplays {
	
	public static ResultSet Upbooking(String username)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			
			String query = "SELECT refno,location,hotel,checkin,checkout,noofrooms,noofpeople,status FROM bookinginfo WHERE Userinfo='"+username+"' and status ='UPCOMING'";
			rs = MyConnection.executeQuery(query);
			return rs;
		}catch(Exception e)
		{
			return rs;
		}
		
	}
	public static ResultSet Prevbooking(String username)
	{
	MyConnection.getConnection();
	ResultSet rs=null;
	try {
		
		String query = "SELECT refno,location,hotel,checkin,checkout,noofrooms,noofpeople,status FROM bookinginfo WHERE Userinfo='"+username+"' and status !='UPCOMING'";
		rs = MyConnection.executeQuery(query);
		return rs;
	}catch(Exception e)
	{
		return rs;
	}
	}
	
	public static int checkFeedback(int a)
	{
		MyConnection.getConnection();
		String str = null;
		ResultSet rs=null;
		try {
		String query = "select feedback from bookinginfo where refno="+a;
		rs = MyConnection.executeQuery(query);
		if(rs.next())
		{
			System.out.println(a);
			System.out.println(rs.getString(1).equals(null));
			System.out.println(a);
			if(rs.getString(1).equals(str))
			{
				System.out.println(5);
				return 1;
			}
			else
				return 0;
		}
		else
			return 0;
		}catch(Exception e)
		{
			return 1;
		}
		finally {
		MyConnection.closeConnection();
		}
	}
	
	public static String gethotelname(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select hotel from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
				return null;
		}catch(Exception e)
		{
			return null;
		}
		finally {
			MyConnection.closeConnection();
		}
	}
	
	public static String getlocation(int refno)
	{
		MyConnection.getConnection();
		ResultSet rs=null;
		try {
			String query = "select location from bookinginfo where refno="+refno;
			rs = MyConnection.executeQuery(query);
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
				return null;
		}catch(Exception e)
		{
			return null;
		}
		finally {
			MyConnection.closeConnection();
		}
	}

}

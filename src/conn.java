import java.sql.*;
public class conn {
	Connection con;
	Statement st;
	
	public conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create the connection Object.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_data","root","MetalBi@#1");
			
			if (con != null) {
				System.out.println("Database is connected sucessfully.");
				
			}
			st = con.createStatement();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
		
	}


import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
		Connection con;
		Statement st;
		int val;
		ResultSet rows;
		
		public DbConnection() {
			
			
			// Register the driver class
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
		
		public int insert(String query) {
			//execure query
			try {
				st.executeUpdate(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		return val;
			

		}
		public ResultSet select(String query) {
			try {
				 rows =st.executeQuery(query);		
		}
			catch(SQLException throwables) {
				throwables.printStackTrace();
				
			}
			return rows;
	}
		
	public static void main(String[] args) {
		new DbConnection();
	}
	}
	
	

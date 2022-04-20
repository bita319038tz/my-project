package cosmetic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	
//	private String databaseUrl = "jdbc:mysql://localhost:3306/cosmetic";
//	private String databaseUsername = "root";
//	private String databasePassword = "";
	
	//public JDBC () {}
	
	public Connection getConnection ()  {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//connection = DriverManager.getConnection(databaseUrl,databaseUsername,databasePassword);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/cosmetic","root","");
		}catch(SQLException ex) {
			//ex.printStackTrace();
			System.out.println(ex.getMessage());
		}catch (ClassNotFoundException ex) {
			//ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		//System.out.println("Connection "+connection);
		return connection;
	}
}

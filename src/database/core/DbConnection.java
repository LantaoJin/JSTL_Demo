package database.core;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public Connection getConnection(){
		//load the driver for mysql
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//getting connection 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lf_lab1","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The connection is not established, returning null "+e.getMessage());
			e.printStackTrace();
		}
		return con;
		//com.mysql.jdbc.Driver
	}
}

/**
 * 
 */
package rp.servlets.rajan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rp.beans.rajan.Rajan;

/**
 * @author root
 *
 */
public class ExampleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String str = request.getParameter("id");
		Integer i = Integer.parseInt(str);
		PrintWriter out= null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(5);
		}
		Rajan raj = new Rajan();
		raj.setId(i);
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/lf_lab1","rajan", "rajan");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees where id = "+i);
			// displaying records
			while(rs.next()){
				out.print(rs.getObject(1).toString());
				out.print("\t\t\t");
				out.print(rs.getObject(2).toString());
				out.print("<br>");
			}
		} catch (SQLException e) {
			System.out.println("exception1");;
		} catch (ClassNotFoundException e) {
			//System.out.println("exception2");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {}
		}
		out.close();
	}

}

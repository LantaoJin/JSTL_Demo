package database.core;

import java.sql.SQLException;
import java.util.List;

import database.layers.Employee;
import database.layers.EmployeeDao;
import database.layers.EmployeeDaoImpl;


public class Test {
	public void insertTestEmployee()throws SQLException {
		/*DbConnection dbcon = new DbConnection();
		Connection con = dbcon.getConnection();
		if(con!=null){
			String sql = "Insert into department (name) values ('Hr2')";
			Statement stmt= con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("The command executed successfully");
			stmt.close();
		}else{
			System.out.println("The connection failed to establish");
		}*/
		Employee e = new Employee();
		e.setAddress("pokhara");
		e.setFull_name("bhuwan gautam ");
		e.setGender("male");
		e.setUser_id(5);
		e.setPhone("abcde");
		
		EmployeeDao edo = new EmployeeDaoImpl();
		edo.insertEmployee(e);
		System.out.println("The row is inserted.");
		
	}
	public void readEmployees(){
		EmployeeDao ed = new EmployeeDaoImpl();
		try {
			Employee e = ed.selectEmployee(1);
			System.out.println("##Employee profile ##");
			System.out.println(e.getId());
			System.out.println(e.getFull_name());
			System.out.println(e.getGender());
			System.out.println(e.getPhone());
			System.out.println(e.getDept_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void selectAll(){
		EmployeeDao ed = new EmployeeDaoImpl();
		try {
			List<Employee> empList=ed.getAllEmployees();
			for (Employee e: empList){
				System.out.println(e.getFull_name());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateEmployees(){
		EmployeeDao ed = new EmployeeDaoImpl();
		try {
			Employee e = new Employee();
			e.setAddress("naikap1");
			e.setFull_name("rajan ");
			e.setGender("male");
			e.setUser_id(1);
			e.setPhone("9841060062");
			ed.updateEmployee(e);
			System.out.println("update successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void showCount(){
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		int i;
		try {
			i=ed.dept_count();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sorry");
		}
	}
	public static void main(String[] args) {
		Test t = new Test();
		try{
			t.insertTestEmployee();
			//t.showCount();
			//t.selectAll();
			//t.readEmployees();
		}catch(Exception e){
			System.out.println("exception in main");
		}
		//t.readEmployees();
		//t.updateEmployees();
		//t.selectAll();
		
	}
}

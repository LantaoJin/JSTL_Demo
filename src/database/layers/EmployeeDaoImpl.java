package database.layers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.core.Database;
import database.core.DbConnection;


public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void insertEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		con.setAutoCommit(false);
			try{
			String sql = "insert into employees (full_name, gender,phone,address, dept_id ) values (?,?,?,?,?);";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getFull_name());
			ps.setString(2, employee.getGender());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getAddress());
			ps.setInt(5, employee.getDept_id());
			ps.executeUpdate();
			ps.close();
			String sql3 = "select max(id)as id from employees";
			PreparedStatement ps1 = con.prepareStatement(sql3);
			ResultSet r = ps1.executeQuery();
			Integer emp_id = 0;
			if(r!=null){
				while(r.next()){
					emp_id = r.getInt("id");
				}
			}
			r.close();
			ps1.close();
			String sql2 = "insert into address (id, emp_id, address) values (?,?,?);";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1,employee.getId());
			ps2.setInt(2,  emp_id);
			ps2.setString(3, employee.getAddress());
			ps2.executeUpdate();
			ps2.close();
			con.commit();
			con.close();
			System.out.println("committed successfully");
			
			}catch(Exception e){
				System.out.println("rolling back");
				con.rollback();
				con.close();
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteEmployee(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Delete from employees where (id = ? );";
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		con.close();
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		try{
		String sql = "UPDATE `employees` set full_name=?, gender=?, phone=?," +
				"address=?, dept_id=? where (id = ? );";
		System.out.println(sql);
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, employee.getFull_name());
		System.out.println("full_name= "+employee.getFull_name());
		ps.setString(2, employee.getGender());
		System.out.println("gender= "+employee.getGender());
		ps.setString(3, employee.getPhone());
		System.out.println("phone= "+employee.getPhone());
		ps.setString(4, employee.getAddress());
		System.out.println("address= "+employee.getAddress());
		ps.setInt(5, employee.getDept_id());
		System.out.println("dept_id= "+employee.getDept_id());
		ps.setInt(6, employee.getId());
		System.out.println("id= "+employee.getId());
		
		//System.out.println(employee.getDept_id());
		ps.executeUpdate();
		//ps.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllEmployees()throws SQLException {
		// TODO Auto-generated method stub
			List<Employee> empList = new ArrayList<Employee>();
				String sql = "Select * from employees;";
				DbConnection db = new DbConnection();
				Connection con = db.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet r = ps.executeQuery();
				
				if(r!=null){
					while(r.next()){
						Employee e = new Employee();
						e.setId(r.getInt("id"));
						e.setFull_name(r.getString("full_name"));
						e.setGender(r.getString("gender"));
						e.setPhone(r.getString("phone"));
						e.setAddress(r.getString("address"));
						e.setUser_id(r.getInt("dept_id"));
						empList.add(e);
					}
					r.close();
					ps.close();
					con.close();
				}
				return empList;
	}

	@Override
	public Employee selectEmployee(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Select * from employees where (id = ? );";
		DbConnection db = new DbConnection();
		//Database db = new Database();
		//db.setDefaultParameters();
		//db.setConnection(true);
		Connection con=null;
		if(db == null){
			System.out.println("Null database");
			System.exit(1);
		}
		con = db.getConnection();
		if(con == null){
			System.out.println("Null connection");
			System.exit(2);
		}
		PreparedStatement ps = null;
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet r = ps.executeQuery();
		Employee e = new Employee();
		if(r!=null){
			if(r.next()){
				e.setId(r.getInt("id"));
				e.setFull_name(r.getString("full_name"));
				e.setGender(r.getString("gender"));
				e.setPhone(r.getString("phone"));
				e.setAddress(r.getString("address"));
				e.setUser_id(r.getInt("dept_id"));
			}
			r.close();
			ps.close();
			con.close();
		}
		return e;
		//return null;
	}

	public Integer dept_count() throws SQLException{
		
		String sql1 ="{ call dept_count(?) }";
		//String sql2 ="select @var";
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		CallableStatement ps = con.prepareCall(sql1);
		//PreparedStatement ps2 = con.prepareStatement(sql1);
		ps.setString(1, "var");
		ResultSet rs = ps.executeQuery();
		Integer count=null;
		if(rs!=null){
			if(rs.next()){
				count = rs.getInt(1);
			}
		}
		con.close();
		return count;
	}
}

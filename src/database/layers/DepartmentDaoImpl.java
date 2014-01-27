/**
 * 
 */
package database.layers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.core.DbConnection;

/**
 * @author root
 *
 */
public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public void insertDepartment(Department d) throws SQLException {
		String sql = "insert into department (name) values (?);";
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, d.getName());
		ps.executeUpdate();
		con.close();
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException{
		// TODO Auto-generated method stub
		Connection con = null;
		DbConnection dc = new DbConnection();
		con = dc.getConnection();
		if(con == null){
			System.out.println("Connection error in DepartmentDaoImpl line 57");
			System.exit(5);
		}
		
		String sql = "update departments set name = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dept.getName());
		ps.setInt(2, dept.getId());
		Integer status=ps.executeUpdate();
		
	}

	@Override
	public void deleteDepartment(Integer id) throws SQLException{
		// TODO Auto-generated method stub
		Connection con = null;
		DbConnection dc = new DbConnection();
		con = dc.getConnection();
		if(con == null){
			System.out.println("Connection error in DepartmentDaoImpl line 57");
			System.exit(5);
		}
		
		String sql = "DELETE from departments where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	@Override
	public List<Department> getAllDepartments()throws SQLException {
		List<Department> depList = new ArrayList<Department>();
		String sql = "Select * from departments;";
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet r = ps.executeQuery();
		
		if(r!=null){
			while(r.next()){
				Department e = new Department();
				Integer i = (r.getInt("id"));
				e.setId(i);
				e.setName(r.getString("name"));
				depList.add(e);
			}
			r.close();
			ps.close();
			con.close();
		}
		return depList;
		
	}

	@Override
	public Department selectDepartment(Integer id) throws SQLException{
		// TODO Auto-generated method stub
		Department d = null;//new Department ();
		Connection con = null;
		ResultSet rs = null;
		DbConnection dc = new DbConnection();
		con = dc.getConnection();
		if(con == null){
			System.out.println("Connection error in DepartmentDaoImpl line 57");
			System.exit(5);
		}
		
		String sql = "select * from departments where id = "+id;
		PreparedStatement ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		if(rs!=null){
			if(rs.next()){
				d = new Department ();
				d.setId(id);
				d.setName(rs.getString("name"));
			}
		}
		return d;
	}
	
}

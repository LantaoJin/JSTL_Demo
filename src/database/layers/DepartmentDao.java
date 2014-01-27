package database.layers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface DepartmentDao {
	public void insertDepartment(Department d) throws SQLException;
	public Department selectDepartment(Integer id)throws SQLException;
	public void updateDepartment(Department dep)throws SQLException;
	public void deleteDepartment(Integer id)throws SQLException;
	public List<Department> getAllDepartments()throws SQLException;//ok
	
}

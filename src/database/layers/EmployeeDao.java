package database.layers;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
	public void insertEmployee(Employee employee) throws SQLException;
	public void deleteEmployee(Integer id) throws SQLException;
	public Employee selectEmployee(Integer id)throws SQLException;
	public void updateEmployee(Employee employee) throws SQLException;
	public List<Employee> getAllEmployees()throws SQLException;
}

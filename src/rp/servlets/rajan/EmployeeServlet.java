package rp.servlets.rajan;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.layers.Employee;
import database.layers.EmployeeDao;
import database.layers.EmployeeDaoImpl;


/**
 * 
 */

/**
 * @author root
 *
 */
public class EmployeeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("The parameter id is : "+id);

		//DepartmentDao ed = new DepartmentDaoImpl();
		EmployeeDao ed = new EmployeeDaoImpl();
		try {
			PrintWriter out = response.getWriter();
			//Department d = ed.selectDepartment(Integer.parseInt(id));
			Employee e = ed.selectEmployee(1);
			out.println("##Employee profile ##<br/>");
			out.println(e.getId()+"<br/>");
			out.println(e.getFull_name()+"<br/>");
			out.println(e.getGender()+"<br/>");
			out.println(e.getPhone()+"<br/>");
			out.println(e.getDept_id()+"<br/>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

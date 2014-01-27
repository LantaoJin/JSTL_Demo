<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean class="database.layers.EmployeeDaoImpl" id="empImpl" />
<jsp:useBean class="database.layers.Employee" id="e" />
<jsp:useBean class="database.layers.DepartmentDaoImpl" id="depImpl" />
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
		if(request.getParameter("update")!=null){
			String fullName = request.getParameter("full_name");
			e.setFull_name(fullName);
			String gender = request.getParameter("gender");
			e.setGender(gender);
			String phone	=	request.getParameter("phone");
			e.setPhone(phone);
			String address	=	request.getParameter("address");
			e.setAddress(address);
			Integer dept_id = Integer.parseInt(request.getParameter("dept_id"));
			e.setDept_id(dept_id);
			Integer id = Integer.parseInt(request.getParameter("id"));
			e.setId(id);
			//System.out.println(dept_id);//working
			empImpl.updateEmployee(e);
			response.sendRedirect("viewEmp.jsp");
		}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/public/styles/style1.css" />
<script type="text/javascript" src="resources/public/scripts/script.js" ></script>
<style type="text/css">

</style>
</head>
<body>
	<%
		Integer id = Integer.parseInt(request.getParameter("id"));
		e = empImpl.selectEmployee(id);
		request.setAttribute("dept_id", e.getDept_id());
	%>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/Header.jsp"></jsp:include>
		<div id="content">
			<form method="post">
				<input type="hidden" name="id" value="<%=id %>" />
				<label>FullName: </label><br/>
				<input type="text" name="full_name" value="<%=e.getFull_name()%>"/><br/>
				<label>gender: </label><br/>
				<input type="text" name="gender" value="<%=e.getGender()%>" /><br/>
				<label>Phone Number: </label><br/>
				<input type="text" name="phone" value="<%=e.getPhone()%>" /><br/>
				<label>address:</label><br/>
				<input type="text" name="address" value="<%=e.getAddress()%>" /><br/><br/>
				<label>Department: </label>
				<select name="dept_id"  >
				<c:forEach items="${depImpl.getAllDepartments() }" var="dept">
					<option value='<c:out value="${dept.id }"/>'<c:if
					 test="${dept_id==dept.id }"> selected="selected" </c:if>>
					<c:out value="${dept.name }" /></option>
				</c:forEach>
				</select><br/><br/><br/>
				<input type="submit" name="update" value="Update Employee" />
			</form>
		</div>
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>
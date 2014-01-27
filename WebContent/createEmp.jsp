<%@page import="org.apache.jasper.tagplugins.jstl.core.Redirect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean class="database.layers.EmployeeDaoImpl" id="empImpl" />
<jsp:useBean class="database.layers.Employee" id="e" />
<jsp:useBean class="database.layers.DepartmentDaoImpl" id="depImpl" />
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
	<%
		if(request.getParameter("create")!=null){
			String fullName = request.getParameter("fullName");
			e.setFull_name(fullName);
			String gender = request.getParameter("gender");
			e.setGender(gender);
			String phone	=	request.getParameter("phone");
			e.setPhone(phone);
			String address	=	request.getParameter("address");
			e.setAddress(address);
			Integer dept_id = Integer.parseInt(request.getParameter("dept_id"));
			e.setDept_id(dept_id);
			empImpl.insertEmployee(e);
			response.sendRedirect("viewEmp.jsp");
		}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="resources/public/styles/style1.css" />
<script type="text/javascript" src="resources/public/scripts/script.js" ></script>
<style type="text/css">

</style>
<title>Insert title here</title>
</head>
<body>
		<div id="wrapper">
		<jsp:include page="/WEB-INF/Header.jsp"></jsp:include>
		<div id="content">
			<form method="post">
				<label>FullName:</label><br/>
				<input type="text" name="fullName" /><br/>
				<label>gender:</label><br/>
				<input type="text" name="gender" /><br/>
				<label>phone:</label><br/>
				<input type="text" name="phone" /><br/>
				<label>address:</label><br/>
				<input type="text" name="address" /><br/><br/>
				<label>Department: </label>
				<select name="dept_id">
				<c:forEach items="${depImpl.allDepartments }" var="dept">
					<option value='<c:out value="${dept.id }" />'><c:out value="${dept.name }" /></option>
				</c:forEach>
				</select><br/><br/><br/>
				<input type="submit" name="create" value="CreateNewEmployee" />
			</form>
		</div>
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>
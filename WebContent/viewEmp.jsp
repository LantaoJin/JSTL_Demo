<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %><%@ page import="java.util.List" 
%><%@ page import="java.util.ArrayList" 
%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean class="database.layers.EmployeeDaoImpl" id="empImpl" />
<jsp:useBean class="database.layers.Employee" id="e" />

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
			<table border="1px">
			<tr><th>name</th><th>option</th></tr>
<%
				if(request.getParameter("id")!=null){
					String id = request.getParameter("id");
					
					Integer int_id = Integer.parseInt(id);
					//e = empImpl.selectEmployee(int_id);
					empImpl.deleteEmployee(int_id);
					response.sendRedirect("viewEmp.jsp");
				}
%>
			<c:forEach var="o" items="${empImpl.allEmployees}" >
	  	<tr>
		  	<td><c:out value="${o.full_name }" /></td>
		  	<td>
		  	<a href='<c:url value="editEmp.jsp">
				  		<c:param name="id" value="${o.id }"/>
				  	</c:url>'>Edit</a> / 
			<a href='<c:url value="viewEmp.jsp">
				  		<c:param name="id" value="${o.id }"/>
				  	</c:url>'>Delete</a>  	
		  	</td>
		  	<!-- <td><c:out value="${o.full_name }" /></td -->
		  </tr>
		  	
		</c:forEach>
		</table>
		<form method="post" action="createEmp.jsp">
			<input type="submit" name="createNew" value="Add New Employee"/>
		</form>
	</div>
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>
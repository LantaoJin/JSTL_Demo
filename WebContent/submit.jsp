<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="database.layers.EmployeeDaoImpl" id="empImpl" />
<jsp:useBean class="database.layers.Employee" id="e" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
The form is here.<br/>
<%
	String id = request.getParameter("id");
	Integer int_id = Integer.parseInt(id);
	e = empImpl.selectEmployee(int_id);
	out.println("##Employee profile ##<br/>");
	out.println(e.getId()+"<br/>");
	out.println(e.getFull_name()+"<br/>");
	out.println(e.getGender()+"<br/>");
	out.println(e.getPhone()+"<br/>");
	out.println(e.getDept_id()+"<br/>");
%>
</body>
</html>
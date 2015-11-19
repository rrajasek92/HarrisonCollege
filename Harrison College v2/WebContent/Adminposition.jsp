<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Position</title>
<%  
String id= request.getParameter("id");
System.out.println("id=====-----===="+id);
session.setAttribute("studentid", id);
%>
<form action="Adminposition">
  <select name="Position">
    <option value="student">student</option>
    <option value="advisor">advisor</option>
    <option value="instructor">instructor</option>
    <option value="admin">admin</option>
    
  </select>
  <br><br>
  <input type="submit">
</form>

</head>
<body>




</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="Style/stylesheet.css">
</head>
<body style=background-color:"white">


<div class = "container"><br><br>
<a href="adm_main.jsp" class="btn btn-default btn-sm active" role="button">Home</a>
<a href="adm_Course" class="btn btn-default btn-sm active" role="button">Courses</a>
<a href="adm_Classroom" class="btn btn-default btn-sm active" role="button">Classrooms</a>
<a href="adm_Department" class="btn btn-default btn-sm active" role="button">Departments</a>
<a href="admin" class="btn btn-default btn-sm active" role="button">Change Roles</a>
<a href="adminCatalogBrowsing?search_type=ac_cs" role="button" class="btn btn-default btn-sm active">All classes in current semester</a>
<a href="logout" class="btn btn-default btn-sm active" role="button">Logout</a>

</body>
</html>
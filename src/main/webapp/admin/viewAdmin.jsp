<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
  response.addHeader("Pragma", "no-cache"); //https://www.oreilly.com/library/view/javaserver-pages-3rd/0596005636/ch17s06.html
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/myproject3.0/login.jsp");
  %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<title>View admin</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">             
  		<a class="navbar-brand" href="EquipmentController?action=listAll">List All</a>
  		<a class="navbar-brand" href="AdminController?action=listAdmin">Manage Admin</a>
  		<a class="navbar-brand" class="active" href="StudentController?action=listStudent">Manage student</a>
  		<a class="navbar-brand" href="EquipmentController?action=listEquipment">Manage Equipment</a> 
  		<a class="navbar-brand" href="RegisterController">Register User</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container">
<br><br>
<h3>View Admin</h3>
<br><br>
		<label for="id">Admin ID</label>: <c:out value="${admin.adminid}"/><br>
    	<label for="name">Name</label>: <c:out value="${admin.name}"/><br>    	 	
        <a href="AdminController?action=listAdmin" class="btn btn-warning">Admin List</a>
        
</div>
</body>
</html>
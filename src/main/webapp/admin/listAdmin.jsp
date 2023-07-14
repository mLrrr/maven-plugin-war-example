  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
  response.addHeader("Pragma", "no-cache");
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
	<title>List Student</title>

</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">           
  		<a class="navbar-brand" href="EquipmentController?action=listAll">List All</a>
  		<a class="navbar-brand" href="AdminController?action=listAdmin">Manage Admin</a>
  		<a class="navbar-brand" href="StudentController?action=listStudent">Manage Student</a>
  		<a class="navbar-brand" class="active" href="EquipmentController?action=listEquipment">Manage Equipment</a> 
  		<a class="navbar-brand" href="RegisterController">Register User</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container"></div>
<div class="container">
<br><br>
<h3>List of Admin</h3>
<table class="table table-striped" style="width:100%">
  <tr>
    <th>Admin ID</th>
    <th>Name</th>
    <th>ID</th>
    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${users}" var="user" varStatus="admin">
  <tr>
    <td><c:out value="${user.admin.adminid}" /></td>
    <td><c:out value="${user.admin.name}" /></td>
    <td><c:out value="${user.id}" /></td>
    <td><a href="AdminController?action=viewAdmin&adminid=<c:out value="${user.admin.adminid}" />" class="btn btn-warning">View</a></td>
    <td><a href="AdminController?action=updateAdmin&adminid=<c:out value="${user.admin.adminid}" />" class="btn btn-primary">Update</a></td>
  </c:forEach>
</table>
</div>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>
</html>
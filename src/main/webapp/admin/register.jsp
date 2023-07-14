<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>     
<%
response.addHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.addHeader("Cache-Control", "pre-check=0, post-check=0");
response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	 
      response.sendRedirect("/myproject2.0/login.jsp");
  %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">	
	<title>Register User</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">               
  		<a class="navbar-brand" href="EquipmentController?action=listAll">List All</a>
  		<a class="navbar-brand" href="AdminController?action=listAdmin">Manage Admin</a>
  		<a class="navbar-brand" href="StudentController?action=listStudent">Manage Student</a>
  		<a class="navbar-brand" href="EquipmentController?action=listEquipment">Manage Equipment</a> 
  		<a class="navbar-brand" class="active" href="RegisterController">Register User</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container">
<br><br>
<h3>Register User</h3>
<br><br>
<form action="RegisterController" method="POST">
 <div class="mb-3">
    <label for="email" class="form-label">Email</label>    
    <input type="email" class="form-control" id="email" name="email" placeholder="Email..">   
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>    
    <input type="password" class="form-control" id="password" name="password" placeholder="Password..">   
  </div>
    <div class="mb-3">
    <label for="role" class="form-label">Role</label> <br>   
    <input type="radio" id="role" name="role" value="admin">Admin
    <input type="radio" id="role" name="role" value="Student">Student   
  </div>
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit"> 
    <input type="reset" class="btn btn-primary" value="Reset">  
  </div>
  </form>
</div>
</body>
</html>

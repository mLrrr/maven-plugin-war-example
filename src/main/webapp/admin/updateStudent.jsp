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
	<title>Update student</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">              
  		<a class="navbar-brand" href="EquipmentController?action=listAll">List All</a>
  		<a class="navbar-brand" href="AdminController?action=listAdmin">Manage Admin</a>
  		<a class="navbar-brand" class="active" href="StudentController?action=listStudent">Manage Student</a>
  		<a class="navbar-brand" href="EquipmentController?action=listEquipment">Manage Equipment</a> 
  		<a class="navbar-brand" href="RegisterController">Register User</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container"></div>
<div class="container">
<br><br>
<h3>Update Student</h3>
<br><br>
  <form action="StudentController" method="POST">
  <div class="mb-3">
    <label for="sid" class="form-label">Student Id</label>
        <input type="text" class="form-control" name="sid" value="<c:out value="${student.sid}"/>" readonly/> 
  </div> 
    <div class="mb-3">
    <label for="name" class="form-label">Name</label>
    <input type="text" class="form-control" id="name" name="name" value="<c:out value="${student.name}"/>">    
  </div>
  <div class="mb-3">
    <label for="programmecode" class="form-label">Programme Code</label>
    <input type="text" class="form-control" id="programmecode" name="programmecode" value="<c:out value="${student.programmecode}"/>">   
  </div>
  <div class="mb-3">
    <label for="programmename" class="form-label">Programme Name</label>
    <input type="text" class="form-control" id="programmename" name="programmename" value="<c:out value="${student.programmename}"/>">   
  </div>
    <div class="mb-3">    
        <input type="hidden" class="form-control" name="id" value="<c:out value="${student.id}"/>"/> 
    </div> 
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit">
    <input type="reset" class="btn btn-primary" value="Reset">
  </div>     
  </form>
</div>

</body>
</html>

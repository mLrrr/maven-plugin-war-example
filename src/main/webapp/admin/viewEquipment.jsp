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
	<title>View equipment</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">          
  		<a class="navbar-brand" href="EquipmentController?action=listAll">List All</a>
  		<a class="navbar-brand" href="AdminController?action=listAdmin">Manage Admin</a>
  		<a class="navbar-brand" href="StudentController?action=listSupplier">Manage Student</a>
  		<a class="navbar-brand" class="active" href="EquipmentController?action=listEquipment">Manage Equipment</a> 
  		<a class="navbar-brand" href="RegisterController">Register User</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container">
<br><br>
<h3>View Equipment</h3>
<br><br>
		<label for="eid">Equipment ID</label>: <c:out value="${equipment.eid}"/><br>
    	<label for="equipmentname">equipment Name</label>: <c:out value="${equipment.equipmentname}"/><br>
    	<label for="brand">brand</label>: <c:out value="${equipment.brand}"/><br>    
    	<label for="model">model</label>: <c:out value="${equipment.model}"/><br>        	
    	<label for="price">Price</label>: <c:out value="${equipment.price}"/><br>	
      	<label for="quantity">Quantity</label>: <c:out value="${equipment.quantity}" /><br>    	
        <label for="eid">Student Id</label>: <c:out value="${equipment.sid}"/><br><br>   	   
        <a href="EquipmentController?action=listEquipment" class="btn btn-warning">equipment List</a>
        
</div>
</body>
</html>

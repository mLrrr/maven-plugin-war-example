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
	<title>Add Equipment</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">              
  		<a class="navbar-brand" href="EquipmentController?action=listAll">List All</a>
  		<a class="navbar-brand" href="AdminController?action=listAdmin">Manage Admin</a>
  		<a class="navbar-brand" href="StudentController?action=listSupplier">Manage Supplier</a>
  		<a class="navbar-brand" class="active" href="EquipmentController?action=listEquipment">Manage Equipment</a> 
  		<a class="navbar-brand" href="RegisterController">Register User</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>

<div class="container">
<br><br>
<h3>Add Equipment</h3>
<br><br>
  <form action="EquipmentController" method="POST">  
  <div class="mb-3">
    <label for="equipmentname" class="form-label">Equipment Name</label>    
    <input type="text" class="form-control" id="equipmentname" name="equipmentname" placeholder="Equipment Name..">   
  </div>
  <div class="mb-3">
    <label for="brand" class="form-label">Brand</label>    
    <input type="text" class="form-control" id="brand" name="brand" placeholder="brand..">   
  </div>
  <div class="mb-3">
    <label for="model" class="form-label">Model</label>    
    <input type="text" class="form-control" id="model" name="model" placeholder="Model..">   
  </div>
  <div class="mb-3">
    <label for="price" class="form-label">Price</label>    
    <input type="text" class="form-control" id="price" name="price" placeholder="Price..">   
  </div>
  <div class="mb-3">
    <label for="quantity" class="form-label">Quantity</label>    
    <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity..">    
  </div>
  <div class="mb-3">
  <label for="studentname" class="form-label">Student Name</label>    
    <select class="form-control" id="sid" name="sid">  
     	<c:forEach items="${sups}" var="student"> 
      		<option style="color:black" value="<c:out value='${student.sid}'/>"><c:out value="${student.sid}" /> - <c:out value="${student.name}" /></option>
      	</c:forEach>
    </select>
  </div> 
  <div class="mb-3">
    <input type="submit" class="btn btn-primary" value="Submit"> 
    <input type="reset" class="btn btn-primary" value="Reset">  
  </div>
  </form>
</div>

</body>
</html>

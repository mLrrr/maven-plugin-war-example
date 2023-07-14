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
	<title>List All</title>	
</head>
<body>

<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">            
  		<a class="navbar-brand" class="active" href="EquipmentController?action=listAll">List All</a>
  		<a class="navbar-brand" href="AdminController?action=listAdmin">Manage Admin</a>
  		<a class="navbar-brand" href="StudentController?action=listStudent">Manage Student</a>
  		<a class="navbar-brand" href="EquipmentController?action=listEquipment">Manage Equipment</a> 
  		<a class="navbar-brand" class="active" href="RegisterController">Register User</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container"></div>
<div class="container">
	<%	String email = (String)session.getAttribute("sessionEmail");%>
	Welcome <b> <%= email %> </b>
</div>
<div class="container">
<br><br>
<h3>List of Student and Equipment</h3>
<br><br>
<table id="list" class="table table-striped" style="width:100%">
  <tr>
    <th>student Id</th>
    <th>student Name</th>
    <th>equipment Id</th>
    <th>equipment Name</th>
    <th>Quantity</th>
    <th colspan="2">Actions</th>
  </tr>
 <c:forEach items="${equipments}" var="equipment">
  	<tr>
    <td><c:out value="${equipment.student.sid}" /></td>
    <td><c:out value="${equipment.student.name}" /></td>
    <td><c:out value="${equipment.eid}" /></td>
    <td><c:out value="${equipment.equipmentname}" /></td>  
    <td><c:out value="${equipment.quantity}" /></td>   
    <td><a href="StudentController?action=viewstudent&sid=<c:out value="${equipment.student.sid}" />" class="btn btn-primary">View student</a></td>
    <td><a href="EquipmentController?action=viewequipment&eid=<c:out value="${equipment.eid}" />" class="btn btn-primary">View equipment</a></td>     
     </tr>	   
    </c:forEach>       
</table>
</div>
<script>
$(document).ready(function() {
    $('#list').DataTable();
} );
</script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

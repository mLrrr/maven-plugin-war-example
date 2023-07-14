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
<h3>List of Equipment</h3>
<br><br>
<a href="EquipmentController?action=addEquipment" class="btn btn-success" style="float:right">ADD EQUIPMENT</a><br><br>
<table class="table table-striped" style="width:100%">
  <tr>
    <th>Equipment Id</th>
    <th>Equipment Name</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Student Id</th> 
    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${equipments}" var="equipment" varStatus="p">
  <tr>
    <td><c:out value="${equipment.eid}" /></td>
    <td><c:out value="${equipment.equipmentname}" /></td>
    <td><c:out value="${equipment.brand}" /></td>
    <td><c:out value="${equipment.model}" /></td>
    <td><c:out value="${equipment.price}" /></td>
    <td><c:out value="${equipment.quantity}" /></td>
    <td><c:out value="${equipment.sid}" /></td>
    <td><a href="EquipmentController?action=viewEquipment&eid=<c:out value="${equipment.eid}" />" class="btn btn-warning">View</a></td>
    <td><a href="EquipmentController?action=updateEquipment&eid=<c:out value="${equipment.eid}" />" class="btn btn-primary">Update</a></td>
    <td><input type="hidden" id="eid-${e.index}" value="<c:out value="${equipment.eid}"/>"><button class="btn btn-danger" onclick="confirmation('${e.index}')">Delete</button></td>    
       
  </c:forEach>
</table>
</div>
	<script>
		function confirmation(index){
			  var eid = $("#eid-" + index).val();
			 
			  console.log(eid);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'EquipmentController?action=deleteEquipment&eid=' + eid;
				  alert("equipment successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>
</html>

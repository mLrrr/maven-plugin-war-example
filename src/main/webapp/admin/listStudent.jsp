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
	<title>List of student</title>
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
<div class="container">
<br><br>
<h3>List of student</h3>
<br><br>
<table class="table table-striped" style="width:100%">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Programme code</th>    
    <th>Programme name</th>
    <th>Email</th>
    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${users}" var="user" varStatus="student">
  <tr>
    <td><c:out value="${user.student.sid}" /></td>
    <td><c:out value="${user.student.name}" /></td>
    <td><c:out value="${user.student.programmecode}" /></td>    
    <td><c:out value="${user.student.programmename}" /></td>
    <td><c:out value="${user.email}" /></td>
    <td><a href="StudentController?action=viewstudent&sid=<c:out value="${user.student.sid}" />" class="btn btn-warning">View</a></td>
    <td><a href="StudentController?action=updatestudent&sid=<c:out value="${user.student.sid}" />" class="btn btn-primary">Update</a></td>    
    <td><input type="hidden" id="id-${student.index}" value="<c:out value="${user.id}"/>"><button class="btn btn-danger" onclick="confirmation('${student.index}')">Delete</button></td>
  </c:forEach>
</table>
</div>
<script>
		function confirmation(index){					  
			  var id = $("#id-" + index).val();			 
			  console.log(id);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'StudentController?action=deletestudent&id=' + id;
				  alert("student successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>
</html>

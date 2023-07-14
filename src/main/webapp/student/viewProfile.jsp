<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%  
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<title>View Student</title>
</head>
<body>

<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">                    	  		   		
  		<a class="navbar-brand" href="LogoutController">Logout</a>       		
    </div>
  </nav>
</div>
<div class="container">
	Welcome <b> <c:out value="${users.email}" /> </b>
	
	
<br><br>
<h3>Student Profile</h3>
<br><br>
		<label for="id">student ID</label>: <c:out value="${student.sid}"/><br>
    	<label for="name">Name</label>: <c:out value="${student.name}"/><br>
    	<label for="programmename">Programme name</label>: <c:out value="${student.programmename}"/><br>  
    	<label for="programmecode">Programme code</label>: <c:out value="${student.programmecode}"/><br>      	
    	                                 
</div>
</body>
</html>

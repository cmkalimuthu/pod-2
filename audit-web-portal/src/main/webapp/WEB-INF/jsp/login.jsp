<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Audit Management System</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
	<div class="heading">
		<h1>Audit Management System</h1>
		<hr>
	</div>
	<div class="container">

		<div class="login-content">

			<form:form action="/home" modelAttribute="user" method="post">
				<br>
				<br>
				<!-- <h2 class="title">Welcome</h2> -->
				<div class="input-div one">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div class="div">
						<h5>Username</h5>
						<form:input path="userId" class="input" />
					</div>
				</div>
				<div class="input-div pass">

					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>Password</h5>
						<form:input type="password" path="password" class="input" />
					</div>
				</div>
				<input type="submit" class="btn btn-success" value="Login">
			</form:form>
		</div>
	</div>

</body>
<script type="text/javascript">
	    const inputs = document.querySelectorAll(".input");
	
	
	    function addcl(){
	    	let parent = this.parentNode.parentNode;
	    	parent.classList.add("focus");
	    }
	
	    function remcl(){
	    	let parent = this.parentNode.parentNode;
	    	if(this.value == ""){
	    		parent.classList.remove("focus");
	    	}
	    }
	
	
	    inputs.forEach(input => {
	    	input.addEventListener("focus", addcl);
	    	input.addEventListener("blur", remcl);
	    });

    </script>
y
</html>
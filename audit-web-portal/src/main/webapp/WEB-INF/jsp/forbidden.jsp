<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>forbidden</title>
<script>
	window.location.hash = "";

	// Again because Google Chrome doesn't insert
	// the first hash into the history
	window.location.hash = "";

	window.onhashchange = function() {
		window.location.hash = "";
	}
</script>
<style>
body {
	background:white;
}

html {
	background-color: white;
}

body>div:nth-child(2)>div:nth-child(2) {
	padding: 10px;
}

h1 {
	color: #FFF;
}
</style>
</head>
<body>

	<div class="container">

		<h1 class="m-5 text-center display-3" style="color: black">Forbidden</h1>
		<div class="container">
			<p class="text-center">Access Denied !!</p>
			<a class="btn btn-success text-center"
				href="/loginPage" style="margin-left: 500px;">login</a>
		</div>


	</div>




	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>



</body>
</html>





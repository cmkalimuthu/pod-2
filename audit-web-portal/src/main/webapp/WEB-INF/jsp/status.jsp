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
<title>Audit Response</title>
<script>
    window.location.hash = "";

    // Again because Google Chrome doesn't insert
    // the first hash into the history
    window.location.hash = ""; 

    window.onhashchange = function(){
        window.location.hash = "";
    }
</script>
<style>
body {
	background: white;
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

td {
	background-color: white;
	border-width: 5px;
}

table, th {
	border-width: 5px;
}
</style>


</head>



<body >
	<%@ include file="nav.jsp"%>

	<div class="container justify-content-center">
		<h3 class="m-4 display-4 text-center " style="color: black">Audit
			Status</h3>
		<hr>
		<div align="center" style="margin-top: 200px;">

			<table border="1" cellpadding="5">
				<tr>
					<th>Project Name</th>
					<th>Project Manager</th>
					<th>Project Owner</th>
					<th>Audit Type</th>
					<th>Audit Date</th>
					<th>Execution status</th>
					<th>Remedial Action</th>
					<th></th>

				</tr>

				<tr>
					<td>${auditResponse.getProjectName()}</td>
					<td>${auditResponse.getManagerName()}</td>
					<td>${auditResponse.getOwnerName()}</td>
					<td>${auditResponse.getAuditType()}</td>
					<td>${auditResponse.getAuditDate()}</td>
					<td
						style=";color:white;padding: 10px;;background-color:${auditResponse.getExecutionStatus()}">${auditResponse.getExecutionStatus()}</td>
					<td>${auditResponse.getDuration()}</td>
					<form:form action="/AuditCheckListQuestions"
						modelAttribute="projectDetails" method="post">
						<form:hidden path="projectName"
							value="${auditResponse.getProjectName()}" />
						<form:hidden path="managerName"
							value="${auditResponse.getManagerName()}" />
						<form:hidden path="ownerName"
							value="${auditResponse.getOwnerName()}" />

						<form:form modelAttribute="auditType"
							action="/AuditCheckListQuestions">
							<form:hidden path="auditType"
								value="${auditResponse.getAuditType()}" />


							<td><input type="submit" class="btn btn-info" value="edit" /></td>

						</form:form>
					</form:form>
				</tr>

			</table>

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
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
<title>Project Details - Audit Management System</title>
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
	backgroud-color: white;
}

#projectDetails {
	margin-left: 400px;
}

.btn {
	margin: 70px;
}

#projectDetails {
	width: 500px;
	height: 450px;
}

#projectDetails {
	/* margin-left: 400px; */
	margin-left: 320px;
}

.btn {
	margin:;
	margin-left: 150px;
}

.required {
	color: red;
}
</style>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container">

		<h1 class="m-3 text-center display-4" style="color: black">
			<strong>PROJECT DETAILS</strong>
		</h1>
		<div class="form-group row">
			<form:form action="/AuditCheckListQuestions"
				modelAttribute="projectDetails" method="post"
				class="px-5 py-4 border rounded">

				<div class="form-group col-xs-2">
					<form:label path="projectName">Project Name</form:label>
					<span class="required">*</span>
					<form:input path="projectName" required="required"
						class="form-control" id="ProjectName"
						oninvalid="this.setCustomValidity('fill the project name')"
						oninput="this.setCustomValidity('')" />


					<div class="form-group">
						<form:label path="managerName">Project Manager Name</form:label>
						<span class="required">*</span>
						<form:input path="managerName" required="required"
							class="form-control" id="ProjectManagerName"
							oninvalid="this.setCustomValidity('fill the manager name')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<form:label path="ownerName">Application Owner</form:label>
						<span class="required">*</span>
						<form:input path="ownerName" required="required"
							class="form-control" id="ApplicationOwnerName"
							oninvalid="this.setCustomValidity('fill app owner name')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<label for="AuditType">Audit Type</label> <span class="required">*</span>
						<form:form modelAttribute="auditType">
							<div class="input-group">
								<div class="input-group-prepend">

									<form:radiobutton path="auditType" required="required"
										id="internal" value="Internal" name="audittype"
										aria-label="Radio button for following text input" />

									&nbsp; <label for="Internal"> Internal</label>
								</div>
								<div class="input-group-prepend">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<form:radiobutton path="auditType" id="sox" value="SOX"
										name="audittype"
										aria-label="Radio button for following text input" />

									&nbsp; <label for="SOX"> SOX</label>
								</div>
							</div>
							<input type="submit" class="btn btn-success mt-3 "
								style="left-margin: 80px" value="Submit">
						</form:form>

					</div>
			</form:form>
		</div>
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





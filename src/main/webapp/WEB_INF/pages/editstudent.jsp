<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/custom.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
</head>

<body>

	<div class="form-container">

		<h1>Edit Student Details</h1>

		<form:form method="PUT" modelAttribute="student"
			commandName="student" class="form-horizontal">

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">Student
						Name:</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="name" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="designation">Designation</label>
					<div class="col-md-7">
						<form:input type="text" path="designation" id="designation"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="designation" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="expertise">Expertise</label>
					<div class="col-md-7">
						<form:input type="text" path="expertise" id="expertise"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="expertise" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<form:input path="createdAt" cssClass="form-control" />

			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Save your change"
						class="btn btn-primary btn-sm">
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
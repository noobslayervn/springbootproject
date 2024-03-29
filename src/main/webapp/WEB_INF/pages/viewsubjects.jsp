
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/custom.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
	<h1 align="center">Students List</h1>
	<table id="t02" cellpadding="2">
		<tr>
			<th><a href="/registersubject"><h2>Home Page:Register new
						subject</h2></a></th>

			<th><a align="right" href="/delete"><h2>Delete All
						Subjects</h2></a></th>
		</tr>
	</table>

	<form:form class="form-horizontal">
		<table id="t01" border="2" width="70%" cellpadding="2">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>Start At</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="subject" items="${list}">
				<tr>
					<td>${subject.id}</td>
					<td>${subject.name}</td>
					<td>${subject.description}</td>
					<td>${subject.startingAt}</td>
					<td><button type="submit"
							formaction="/company/editsubject/${subject.id}">EDIT</button></td>
					<td><button type="submit"
							formaction="/company/deletesubject/${subject.id}">DELETE</button></td>
				</tr>
			</c:forEach>


		</table>
		<br />
	</form:form>
</body>
</html>


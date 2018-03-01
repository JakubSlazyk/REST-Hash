<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>

<html>

<head>
	<title>List Hash</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

	<div id="wrapper">
	
		<div id="header">
			<h2>HM - Hash Manager</h2>
		</div>
	
	</div>
	<div id="container">
	
		<div id="content">

			<form:form action="showFormForAdd" method="GET">
				<input type = "text" name="text">
				<input type = "submit" value="Save" class="save"/>
			</form:form>
			<table>
			
				<tr>
					<th>Hash</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempHash" items="${hashes}">
					<c:url var="deleteLink" value="/hash/delete">
						<c:param name="hashId" value="${tempHash.id}"/>
					</c:url>

					<tr>
						<td>${tempHash.hash}</td>
						<td>

							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this hash?')))return false">Delete</a>
						</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	
	</div>

</body>

</html>
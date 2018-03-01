<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html>
<html>
<head>
	<title> Save Hash</title>
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-hash-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>HM - Hash Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Hash</h3>
		
		<form:form action="saveHash" method="POST">
			<table>
				<tbody>
					<tr>
						<td> <label>Hash:</label></td>
						<td><input type="text" value="${hash}" name="hash"/></td>
					</tr>
					<tr>
						<td> <label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>	
		
		</form:form>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/hash/list"> Back to List</a>
		</p>
	</div>

</body>

</html>
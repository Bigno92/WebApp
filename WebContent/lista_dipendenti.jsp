<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees</title>
</head>
<body>
	<h3 align="center">Elenco Dipendenti</h3>
	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Birth Date</td>
			<td>Hire Date</td>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><c:out value='${list.getF_name()}'/></td>
				<td><c:out value='${list.getL_name()}'/></td>
				<td><c:out value='${list.getDate()}'/></td>
				<td><c:out value='${list.getHire_date()}' /></td>
				<td><button type="button" onclick="document.location.href='updEmpPage.jsp?n_emp=${list.getN_emp()}'">Update</button></td>
				<td><button type="button" onclick="document.location.href='delEmpServlet?matr=${list.getN_emp()}'">Delete</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
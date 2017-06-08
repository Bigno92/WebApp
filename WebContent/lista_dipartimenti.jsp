<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Departments</title>
</head>
<body>
 <h3 align="center">Elenco dipartimenti</h3>
          <form action="ListEmplServlet">
                <c:forEach items="${list}" var="list">
                	<input type="radio" value='${list.getNdep()}' name="dep"/>${list.getName()}<br>
                </c:forEach>
                <input type="submit" value="View Departments"/>
          </form>     
          <button type="button" onclick="document.location.href='addEmpPage.jsp'">Add Employee</button>      
</body>
</html>
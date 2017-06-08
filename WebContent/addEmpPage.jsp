<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employees</title>
</head>
<body>
	<h3 align="center">AGGIUNGI UN DIPENDENTE</h3>
	<form action="addEmplServlet">
	<div>
		<label>Matricola</label>
		<div>
			<input type="text" name="matr">
		</div>
	</div>
	<div>
		<label>Data di Nascita</label>
		<div>
			<input type="text" name="date">
		</div>
	</div>
	<div>
		<label>Nome</label>
		<div>
			<input type="text" name="name">
		</div>
	</div>
	<div>
		<label>Cognome</label>
		<div>
			<input type="text" name="cogn">
		</div>
	</div>
	<div>
		<label>Sesso</label>
		<div>
			<input type="text" name="gender">
		</div>
	</div>
	<div>
		<label>Codice Dipartimento</label>
		<div>
			<input type="text" name="dep">
		</div>
	</div>
	<div>
		<label>Data Assunzione</label>
		<div>
			<input type="text" name="date_start">
		</div>
	</div>
	<input type="submit" value="Add Employee" />
	</form>
</body>
</html>
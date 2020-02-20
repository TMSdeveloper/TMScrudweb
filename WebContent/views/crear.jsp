<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar una nueva barra</title>
</head>
<body>
<h1>Ingresar una nueva barra</h1>
<form action="barras" method="post">
	<input type="hidden" name="opcion" value="guardar">
	<table border="1">
	<tr>
		<td>Mineral:</td>
		<td><input type="text" name="ID_mineral"></td>
	</tr>
	<tr>
		<td>Status:</td>
		<td><input type="text" name="ID_status"></td>
	</tr>
	<tr>
		<td>Peso (onzas):</td>
		<td><input type="text" name="or_weight"></td>
	</tr>
	<tr>
		<td>Pureza (%):</td>
		<td><input type="text" name="or_purity"></td>
	</tr>
	</table>

	<input type="submit" value="Guardar">
</form>
</body>
</html>
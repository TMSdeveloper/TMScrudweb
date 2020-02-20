<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar la información sobre una barra</title>
</head>
<body>
<h1>Editar información</h1>
<form action="barras" method="post">
<c:set var="barra1" value="${barra}"></c:set>
	<input type="hidden" name="opcion" value="editar">
	<input type="hidden" name="ID" value="${barra.ID}">
	
	<table border="1">
	<tr>
		<td>Mineral:</td>
		<td><input type="text" name="ID_mineral" value="${barra1.ID_mineral}"></td>
	</tr>
	<tr>
		<td>Status:</td>
		<td><input type="text" name="ID_status" value="${barra1.ID_status}"></td>
	</tr>
	<tr>
		<td>Peso (onzas):</td>
		<td><input type="text" name="or_weight" value="${barra1.or_weight}"></td>
	</tr>
	<tr>
		<td>Pureza (%):</td>
		<td><input type="text" name="or_purity" value="${barra1.or_purity}"></td>
	</tr>
	</table>

	<input type="submit" value="Guardar">
</form>
</body>
</html>
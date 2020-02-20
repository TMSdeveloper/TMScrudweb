<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Listar las barras</title>
</head>
<body>
<h1>Listar barras</h1>

<table border="1">
	<tr>
		<td>ID</td>
		<td>Ingreso</td>
		<td>Mineral</td>
		<td>Status</td>
		<td>Peso</td>
		<td>Pureza</td>
		<td>Actualizado</td>
		<td>Acción</td>	
	</tr>
	<c:forEach var="barra" items="${lista}">
	<tr>
		<td><a href="barras?opcion=meditar&ID=<c:out value="${barra.ID}"></c:out>"><c:out value="${barra.ID}"></c:out></a></td>
		<td><c:out value="${barra.in_date}"></c:out></td>
		<td><c:out value="${barra.ID_mineral}"></c:out></td>
		<td><c:out value="${barra.ID_status}"></c:out></td>
		<td><c:out value="${barra.or_weight}"></c:out></td>
		<td><c:out value="${barra.or_purity}"></c:out></td>
		<td><c:out value="${barra.up_date}"></c:out></td>	
		<td><a href="barras?opcion=eliminar&ID=<c:out value="${barra.ID}"></c:out>">Eliminar</a></td>	
	</tr>
	</c:forEach>

</table>

</body>
</html>
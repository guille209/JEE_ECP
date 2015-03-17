<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ELIMINAR</title>
</head>
<body>
	<form action="eliminarTema" method="POST">
		<select name="nivelEstudios">
			<c:forEach var="value" items="${identificarEliminar.listaTemas}">
				<option value="${value.nombre}">${value.nombre}</option>
			</c:forEach>
		</select> <input type="submit" value="EliminarTema">
	</form>



</body>
</html>
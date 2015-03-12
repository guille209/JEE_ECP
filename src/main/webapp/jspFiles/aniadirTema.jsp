<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A�ADIR TEMA</title>
</head>
<body>
<H1>ES LA HORA DE A�ADIR UN TEMA, ADELANTE!!</H1>
	<c:set var="beanTema" scope="request" value="${a�adirTemaView}" />

	<form action="aniadirTema" method="post">
		<p>
			Nombre:<input name="nombre" type="text"
				value="${beanTema.tema.nombre}" />${pView.errorMsg}</p>
		<p>
			Pregunta:<input name="pregunta" type="text"
				value="${beanTema.tema.pregunta}" />${pView.errorMsg}
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>


</body>
</html>
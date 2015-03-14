<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AÑADIR TEMA</title>
</head>
<body>
<H1>Añadir Tema</H1>
	<!-- <c:set var="beanTema" scope="request" value="${añadirTemaView}" />
-->
	<form action="aniadirTema" method="post">
		<p>
			Nombre:<input name="nombre" type="text"
				value="" /></p>
		<p>
			Pregunta:<input name="pregunta" type="text"
				value="" />
		</p>
		<p>
			<input type="submit" value="Añadir" />
		</p>
	</form>


</body>
</html>
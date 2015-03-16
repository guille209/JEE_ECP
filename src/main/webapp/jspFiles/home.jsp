<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home.css">
<title>Home</title>
</head>
<body>
	<c:set var="beanHome" scope="request" value="${eliminarTema}" />

	<h1>HOME</h1>
	<hr>
	<ul>
		<li><a href="/JEE_ECP/jsp/votar">[JSP]Votar</a></li>
		<li><a href="/JEE_ECP/jsp/verVotaciones">[JSP]Ver votaciones</a></li>
		<li><a href="/JEE_ECP/jsp/aniadirTema">[JSP]Añadir Tema</a></li>
		<form action="/JEE_ECP/jsp/eliminarTema" method="get">
			<li><input type="submit" value="[JSP]Eliminar Tema"><input
				type="text" name="identificadorAutorizacion" placeholder="Identificador"></li> 
		</form>

	</ul>

	${beanHome.errorMsg}



</body>
</html>
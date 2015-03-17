<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver votacionese</title>
</head>
<body>
<c:set var="pView" scope="request" value="${verVotaciones}" />
<div>${pView.update()}</div>
<h1>Ver votaciones</h1>
	<c:forEach var="entry" items="${verVotaciones.numeroVotosPorTema}">
  Tema: <c:out value="${entry.key}" />
  Numero de votos: <c:out value="${entry.value}" />
  <br>
	</c:forEach>
	
	<c:forEach var="entry" items="${verVotaciones.votacionMediaPorEstudios}">
  Nivel de estudios: <c:out value="${entry.key}" />
  Votacion media: <c:out value="${entry.value}" />
  <br>
	</c:forEach>

</body>
</html>
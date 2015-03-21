<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver votaciones</title>
<style>
td {
	text-align: center;
	border-width: thin;
	border-style: solid;
}

table {
	border-width: medium;
	border-style: solid;
	float: left;
}
</style>
</head>
<body>
	<c:set var="pView" scope="request" value="${verVotaciones}" />
	<div>${pView.update()}</div>
	<h1>Ver votaciones</h1>
	<table>
		<thead>
			<th>Tema</th>
			<th>Numero de votos</th>
		</thead>
		<tbody>
			<c:forEach var="entry" items="${verVotaciones.numeroVotosPorTema}">
				<tr>
					<td><c:out value="${entry.key}" /></td>
					<td><c:out value="${entry.value}" /></td>
				</tr>
				<br>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<thead>
			<th>NivelEstudios</th>
			<th>Media</th>
		</thead>
		<tbody>
			<c:forEach var="entry"
				items="${verVotaciones.votacionMediaPorEstudios}">
				<tr>
					<td><c:out value="${entry.key}" /></td>
					<td><c:out value="${entry.value}" /></td>
				</tr>
				<br>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
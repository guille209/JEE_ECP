<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/votar.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/votar.js"></script>

<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${votar.listaTemas}" var="tema">
		<button id="${tema.nombre}">${tema.nombre}</button>
		<p class="oculto" id="pregunta${tema.nombre}">${tema.pregunta}
		<p>
	</c:forEach>

	<form action="votar" method="POST" class="oculto" id="form">
		<label>Valoracion</label> <input type="range" name="valoracion"
			min="0" max="10" onchange="updateTextInput(this.value);"> <input
			type="text" id="textInput" value="" style="width: 10px;" disabled>
		<label>Nivel de estudios</label> <select name="nivelEstudios">
			<c:forEach var="value" items="${votar.listaNivelEstudios}">
				<option value="${value}">${value}</option>
			</c:forEach>
		</select> <input type="text" id="nombreTema" name="nombreTema"
			style="display: none;"> <input type="submit" value="Votar">
	</form>





</body>
</html>
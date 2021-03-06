<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Turismo en la Tierra Media</title>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
<header>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
</header>
	<h2>Hello World!</h2>
	<br>
	<div>

		<c:out value="${productos}"></c:out>
	</div>

	<br>

	<table>
		<c:forEach items="${productos}" var="producto">
			<tr>
				<td><strong><c:out value="${producto.nombre}"></c:out></strong>
				<td><c:out value="${producto.costo}"></c:out></td>
				<td><c:out value="${producto.tiempo}"></c:out></td>
				<td><c:forEach items="${producto.atracciones}" var="atraccion">


						<c:out value="${atraccion.nombre}"></c:out>
		</c:forEach>
		</td>
		</tr>
		</c:forEach>
	</table>
	
	<table>
		<c:forEach items="${promociones}" var="promocion">
			<tr>
				<td><strong><c:out value="${promocion.nombre}"></c:out></strong>
				<td><c:out value="${promocion.costo}"></c:out></td>
				<td><c:out value="${promocion.tiempo}"></c:out></td>
				<td><c:forEach items="${promocion.atracciones}" var="atraccion">


						<c:out value="${atraccion.nombre}"></c:out>
		</c:forEach>
		</td>
		</tr>
		</c:forEach>
	</table>
	
		<table>
		<c:forEach items="${atracciones}" var="atraccion">
			<tr>
				<td><strong><c:out value="${atraccion.nombre}"></c:out></strong>
				<td><c:out value="${atraccion.costo}"></c:out></td>
				<td><c:out value="${atraccion.tiempo}"></c:out></td>
				<td><c:out value="${atraccion.tipo}"></c:out></td>
				<td><c:out value="${atraccion.cupo}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>
 
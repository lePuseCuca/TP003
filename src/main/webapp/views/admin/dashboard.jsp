<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<main class="container">
		
		<h2>Panel de administración</h2>

		<h3>
			Atracciones <a class="btn btn-primary btn-lg btn-floating"
				style="background-color: #ac2bac;" href="#!" role="button"><i
				class="fas fa-plus"></i></a>
		</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>ID</td>
					<td>NOMBRE</td>
					<td>CUPO</td>
					<td>COSTO</td>
					<td>TIEMPO</td>
					<td>TIPO</td>
					<td>ACCIONES</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${atracciones}" var="atraccion">
				<tr>
                    <td><b><c:out value="${atraccion.id}"></c:out></b></td>
                    <td><c:out value="${atraccion.nombre}"></c:out></td>
                    <td><c:out value="${atraccion.cupo}"></c:out></td>
                    <td>$<c:out value="${atraccion.costo}"></c:out></td>
                    <td><c:out value="${atraccion.tiempo}"></c:out> hs.</td>
                    <td><span class="badge rounded-pill pill-<c:out value="${fn:substring(fn:toLowerCase(atraccion.tipo), 0, 3)}"></c:out>"> <c:out value="${atraccion.tipo}"></c:out></span></td>
                    <td>
                        <a href="#"><i class="fas fa-pen-square fs-4 text-warning"></i> </a>
                        <a href="#"><i class="fas fa-trash fs-4 text-danger"></i></a>
                    </td>
                </tr>
			</c:forEach>
			</tbody>
		</table>
	</main>
	

</body>
</html>
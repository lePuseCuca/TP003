<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h2>Bienvenidos a Tierra Media</h2>
	<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
	
	<form action="login" method="post">
		<input type="text" name="nombre" /> <label>Usuario</label> <br>
		<input type="password" name="clave" /> <label>Clave</label> <br>
		<button type="submit">Ingresar</button>
	</form>

</body>
</html>
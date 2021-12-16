<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Usuario</title>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>

<body>
	<header>
		<jsp:include page="/partials/nav.jsp"></jsp:include>
	</header>
	<main class="container-fluid">
		<div class="row col-8 col-md-5 col-sm-6 col-lg-4 mx-auto">
			<h1 class="fs-4 text-center">Agregar usuario</h1>
			<form action="/TP003-LPC/usuario/new.do" method="POST">
				<div class="form-group">
					<label for="nombre">Nombre</label> 
					<input type="text" name="nombre" id="nombre"
						class="form-control" placeholder="Ingresá un nombre de usuario"
						required value="<c:out value="${usuario.nombre}"></c:out>" />		
				</div>
				<div class="form-group">
					<label for="monedas">Monedas</label> <input type="number" name="monedas"
						id="monedas" class="form-control"
						placeholder="Ingresá la cantidad de monedas que dispone" required
						value="<c:out value="${usuario.monedas}"></c:out>" />
				</div>
				<div class="form-group">
					<label for="tiempo">Tiempo</label> <input type="number"
						name="tiempo" id="tiempo" class="form-control"
						placeholder="Ingresá el tiempo que dispone" required
						value="<c:out value="${usuario.tiempo}"></c:out>" />
				</div>
				<div class="form-group">
					<!-- c:forEach items="${tipos}" var="tipo" -->
					<label for="tipo-preferido">Tipo Preferido</label> <select name="tipo-preferido" id="tipo-preferido"
						class="form-control">
						<option value="AVENTURA"> Aventura</option>
						<option value="PAISAJE"> Paisaje</option>
						<option value="DEGUSTACION"> Degustacion </option>
					</select>
					<!-- /c:forEach -->
				</div>
				<div class="form-group">
					<label for="clave">Clave</label> <input type="password" name="clave"
						id="clave" class="form-control"
						placeholder="Ingresá una clave" required
						value="<c:out value="${usuario.clave}"></c:out>" />
				</div>
				<div class="form-group">
					<label for="is-admin">Es Administrador</label> <select name="is-admin" id="is-admin"
						class="form-control">
						<option value="Si"> Si</option>
						<option value="No"> No</option>
					</select>
				</div>

				<div class="form-group mt-3 text-center">
					<button type="submit" class="btn btn-primary">Agregar</button>
				</div>
			</form>
		</div>
	</main>

</body>

</html>

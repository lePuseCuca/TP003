<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modificar Promoción</title>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>

<body>
	<header>
		<jsp:include page="/partials/nav.jsp"></jsp:include>
	</header>
	<main class="container-fluid">
		<div class="row col-8 col-md-5 col-sm-6 col-lg-4 mx-auto">
			<h1 class="fs-4 text-center">Modificar promoción</h1>
			<form action="#" method="POST">
				<div class="form-group">
					<label for="nombre">Nombre</label> <input type="text" name="nombre"
						id="nombre" class="form-control"
						placeholder="Ingresa el nombre de la atracción" required>
				</div>
				<div class="form-group">
					<label for="tipo">Tipo Promoción</label> <select name="" id=""
						class="form-control">
						<option value="">Tipo 1</option>
						<option value="">Tipo 2</option>
						<option value="">Tipo 3</option>
					</select>
				</div>
				<div class="form-group">
					<label for="tipo">Tipo Atracción</label> <select name="" id=""
						class="form-control">
						<option value="">Tipo 1</option>
						<option value="">Tipo 2</option>
						<option value="">Tipo 3</option>
					</select>
				</div>
				<div class="form-group">
					<label for="tipo">Descuento</label> <select name="" id=""
						class="form-control">
						<option value="">Tipo 1</option>
						<option value="">Tipo 2</option>
						<option value="">Tipo 3</option>
					</select>
				</div>

				<div class="form-group mt-3 text-center">
					<button type="submit" class="btn btn-primary">Modificar</button>
				</div>
		</div>
	</main>

</body>

</html>
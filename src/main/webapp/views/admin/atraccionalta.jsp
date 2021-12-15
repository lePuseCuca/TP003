<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Atracción</title>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>

<body>
	<header>
		<jsp:include page="/partials/nav.jsp"></jsp:include>
	</header>
	<main class="container-fluid">
		<div class="row col-8 col-md-5 col-sm-6 col-lg-4 mx-auto">
			<h1 class="fs-4 text-center">Agregar atracción</h1>
			<form action="#" method="POST">
				<div class="form-group">
					<label for="nombre">Id</label> <input type="text" name="id" id="id"
						class="form-control" placeholder="Ingresa el id de la atracción"
						required value="${atraccion.id}"></input>
				</div>
				<div class="form-group">
					<label for="nombre">Nombre</label> <input type="text" name="nombre"
						id="nombre" class="form-control"
						placeholder="Ingresa el nombre de la atracción" required
						value="${atraccion.nombre}"></input>
				</div>
				<div class="form-group">
					<label for="tiempo">Tiempo</label> <input type="number"
						name="tiempo" id="tiempo" class="form-control"
						placeholder="Ingresa el tiempo de la atracción" required
						value="${atraccion.tiempo}"></input>
				</div>
				<div class="form-group">
					<label for="costo">Costo</label> <input type="number" name="costo"
						id="costo" class="form-control"
						placeholder="Ingresa el costo de la atracción" required
						value="${atraccion.costo}"></input>
				</div>
				<div class="form-group">
					<label for="cupo">Cupo</label> <input type="number" name="costo"
						id="cupo" class="form-control"
						placeholder="Ingresa el cupo de la atracción" required
						value="${atraccion.cupo}"></input>
				</div>

				<div class="form-group">
					<!-- c:forEach items="${tipos}" var="tipo" -->
					<label for="tipo">Tipo</label> <select name="tipo" id="tipo"
						class="form-control">

						<option value="${atraccion.tipo}"></option>
					</select>
					<!-- /c:forEach -->
				</div>


				<div class="form-group mt-3 text-center">
					<button type="submit" class="btn btn-primary">Agregar</button>
				</div>
		</div>
	</main>

</body>

</html>
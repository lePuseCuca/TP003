<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Promoción</title>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>

<body>
	<header>
		<jsp:include page="/partials/nav.jsp"></jsp:include>
	</header>
	<main class="container-fluid">
		<div class="row col-8 col-md-5 col-sm-6 col-lg-4 mx-auto">
			<h1 class="fs-4 text-center">Agregar promoción</h1>
			<form action="#" method="POST">
				<div class="form-group">
					<label for="id">ID</label> <input type="text" name="nombre" id="id"
						class="form-control" placeholder="Ingresa el id de la promocion"
						required value="${promociones.nombre}"></input>
				</div>
				<div class="form-group">
					<label for="nombre">Nombre</label> <input type="text" name="nombre"
						id="nombre" class="form-control"
						placeholder="Ingresa el nombre de la atracción" required
						value="${promociones.nombre}"></input>
				</div>
				<div class="form-group">
					<label for="tipoPromocion">Tipo Promocion</label> <select name=""
						id="tipoPromocion" class="form-control">
						<option value="PORCENTUAL">Porcentual</option>
						<option value="ABSOLUTA">Absoluta</option>
						<option value="AXB">AxB</option>
					</select>
				</div>
				<div class="form-group">
					<label for="tipo">Tipo Atracción</label> <select name="" id="tipo"
						class="form-control">
						<option value="AVENTURA">Aventura</option>
						<option value="DEGUSTACION">Degustacion</option>
						<option value="PAISAJE">Paisaje</option>
					</select>
				</div>
				<div class="form-group">
					<label for="descuento">Descuento</label> <input type="text"
						name="nombre" id="descuento" class="form-control" placeholder=""
						required value=""></input>
				</div>
				<div class="form-group">
					<label for="tipo">Atracciones</label>
					<!-- Default checkbox -->
					<div class="form-check" data-tipo-atr="AVENTURA">
						<input class="form-check-input" type="checkbox" value="Moria"
							id="flexCheckDefault" /> <label class="form-check-label"
							for="flexCheckDefault"> Moria </label>
					</div>

					<!-- Checked checkbox -->
					<div class="form-check" data-tipo-atr="DEGUSTACION">
						<input class="form-check-input" type="checkbox" value="Erebor"
							id="flexCheckChecked" checked /> <label
							class="form-check-label" for="flexCheckChecked"> Erebor </label>
					</div>
					</select>


				</div>
		</div>
		<div class="form-group mt-3 text-center">
			<button type="submit" class="btn btn-primary">Agregar</button>
		</div>

	</main>

</body>

</html>
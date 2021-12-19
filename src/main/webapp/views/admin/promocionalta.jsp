<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
			<form action="/TP003-LPC/promocion/new.do" method="POST">
				<div class="form-group mb-3">
					<label for="id">ID</label> <input type="text" name="id" id="id"
						class="form-control" required value="">
				</div>
				<div class="form-group mb-3">
					<label for="nombre">Nombre</label> <input type="text" name="nombre"
						id="nombre" class="form-control" required value=""></input>
				</div>
				<div class="form-group mb-3">
					<label for="tipo-promocion">Tipo Promocion</label> <select
						name="tipo-promocion" id="tipo-promocion"
						class="form-control form-select">
						<option value="default">Elija tipo de Promocion</option>
						<option value="PORCENTUAL">Porcentual</option>
						<option value="ABSOLUTA">Absoluta</option>
						<option value="AXB">AxB</option>
					</select>
				</div>

				<div class="form-group mb-3 tipo-promo" data-tipo-promo="PORCENTUAL">
					<label for="descuento">Descuento %</label> <input type="text"
						name="descuento" id="descuento" class="form-control"
						placeholder="" value="" disabled required></input>
				</div>
				<div class="form-group mb-3 tipo-promo" data-tipo-promo="ABSOLUTA">
					<label for="costo">Costo</label> <input type="text" name="costo"
						id="costo" class="form-control" placeholder="" value="" disabled
						required></input>
				</div>
				<div class="form-group mb-3 tipo-promo" data-tipo-promo="AXB">
					<label for="costo">Atraccion sin cargo</label> <input type="text"
						name="gratis" id="gratis" class="form-control" placeholder=""
						value="" disabled></input>
				</div>
				<div class="form-group mb-3">
					<label for="tipo">Tipo Atracción</label> <select name="tipo"
						id="tipo" class="form-control form-select">
						<option value="default">Elija tipo de Atraccion</option>
						<option value="AVENTURA">Aventura</option>
						<option value="DEGUSTACION">Degustacion</option>
						<option value="PAISAJE">Paisaje</option>
					</select>
				</div>
				<div class="form-group mb-3" id="check-atracciones"
					name="atracciones">
					<label for="check-atracciones">Atracciones</label>

					<div id="check-container">
						<c:forEach items="${atraccionesLista}" var="atraccion">
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="<c:out value="${atraccion.id}"></c:out>"
									id="check<c:out value="${atraccion.id}"></c:out>"
									name="atracciones"
									data-tipo-atr="<c:out value="${atraccion.tipo}"></c:out>"
									disabled> <label class="form-check-label"
									for="check<c:out value="${atraccion.id}"></c:out>"> <span
									class="badge rounded-pill pill-<c:out value="${fn:toLowerCase(fn:substring(atraccion.tipo, 0, 3))}"></c:out>">
										<c:out value="${atraccion.nombre}"></c:out>
								</span>
								</label>
							</div>
						</c:forEach>
					</div>
				</div>
		</div>
		<div class="form-group mb-3 mt-3 text-center">
			<button type="submit" class="btn btn-primary">Agregar</button>
		</div>

	</main>

</body>

</html>
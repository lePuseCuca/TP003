<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bienvenidos a Tierra Media</title>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>



<body class="d-flex login-main">
	<main class="container">
		<div class="row col-8 col-md-5 col-sm-6 col-lg-4 mx-auto"
			id="login-container">
			<h1 class="fs-4 text-center ft-serif">
				Bienvenidos a <br>Tierra Media
			</h1>
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			<form action="login" method="POST">
				<div class="form-group">
					<label for="nombre">Nombre</label> <input type="text" name="nombre"
						id="nombre" class="form-control" placeholder="Ingresa tu nombre"
						required>
				</div>
				<div class="form-group">
					<label for="clave">Contraseña</label> <input type="password"
						name="clave" id="clave" class="form-control"
						placeholder="Ingresa tu contraseña" required>
				</div>
				<div class="form-group mt-3 text-center">
					<button type="submit" class="btn btn-primary">Ingresar</button>
				</div>
		</div>
	</main>
</body>

</body>
</html>
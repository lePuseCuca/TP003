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
	<main class="container-fluid">
		<section id="destacados" class="container">
			<c:set var="active" value="active" />
			<c:set var="preferidos" value="<h2>Basados en tus preferencias</h2>" />
			<div id="atracciones" class="row g-3">
				<h2>Basados en tus preferencias</h2>
				<c:forEach items="${productos}" var="producto">
					
					<c:if test="${usuario.monedas >= producto.costo && usuario.tiempo >= producto.tiempo}">
					<div class="col-lg-4 col-md-6 col-sm-12">
						<div class="card text-center">
							<div class="bg-image hover-overlay ripple"
								data-mdb-ripple-color="light">
								<c:choose>
									<c:when test="${producto.esPromocion()}">
										<img
											src="assets/img/${fn:replace(fn:toLowerCase(producto.atracciones[0].nombre), ' ', '_')}.jpg" />
									</c:when>
									<c:otherwise>
										<img
											src="assets/img/${fn:replace(fn:toLowerCase(producto.nombre), ' ', '_')}.jpg" />
									</c:otherwise>
								</c:choose>
								<a href="#!">
									<div class="mask"
										style="background-color: rgba(251, 251, 251, 0.15)"></div>
								</a>

							</div>
							<div class="card-header">
															<c:if test="${producto.esPromocion() }">
										<span
									class="badge rounded-pill pill-promo">PROMOCION</span>	
								</c:if>
							
								<span
									class="badge rounded-pill pill-<c:out value="${fn:substring(fn:toLowerCase(producto.tipo), 0, 3)}"></c:out>">
										<c:out value="${producto.tipo}"></c:out>
									</span>
							</div>
							<div class="card-body">
								<h5 class="card-title">${producto.nombre}</h5>
								<p class="card-text">Lorem ipsum dolor sit amet consectetur
									adipisicing elit. Error vel in nisi magnam neque ducimus
									sapiente aliquam pariatur nostrum ab?</p>
								<div style="font-size: 1.2rem;">
									<span class="badge bg-info"><i class="fas fa-coins"></i>
										$ <c:out value="${producto.costo}"></c:out></span> 
										<span class="badge bg-info"><i class="fas fa-clock"></i> 
										<c:out value="${producto.tiempo}"></c:out> hs.</span>
									<a href="producto/buy.do?id=<c:out value="${producto.id}"></c:out>"><span
											class="badge bg-success">COMPRAR</span></a>
								</div>

							</div>
						</div>
					</div>
					</c:if>
				</c:forEach>
			</div>
		</section>
	</main>

</body>
</html>

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
		<section class="mx-auto my-5" style="max-width: 30rem;">
			
			<div class="card">
				<div class="card-body">
					<div class="d-flex justify-content-around mb-4">
						<img src="/TP003-LPC/assets/img/<c:out value="${fn:toLowerCase(itinerario.nombreUsuario)}"></c:out>.jpg" class="avatar-iti" />
						<div class="d-flex flex-column align-items-center">
							<h5 class="card-title font-weight-bold">ITINERARIO -
								<c:out value="${fn:toUpperCase(itinerario.nombreUsuario)}"></c:out></h5>
							<p class="card-text">Secretaria de Turismo Tierra Media</p>
						</div>
					</div>
					
					<div class="d-flex justify-content-between mb-2 mx-3">
						<p class="display-6">
							
							<strong> $ <c:out value="${itinerario.costo}"></c:out></strong>
						</p>
						<p class="display-6">
							
							<strong><c:out value="${itinerario.tiempo}"></c:out> hs.</strong>
						</p>
					</div>

					<div class="collapse" id="collapseContent1">
						<table class="table table-borderless table-sm mb-0">
							<tbody>
							<c:forEach items="${itinerario.productos}" var="producto">
								<tr>
									<td class="font-weight-normal fs-6"><strong><c:out value="${producto.nombre}"></c:out>
									</strong> 
									<c:if test="${producto.esPromocion()}">
										<span class="badge rounded-pill bg-promo">PROMO</span>
									</c:if>
										<span class="badge rounded-pill bg-<c:out value="${fn:toLowerCase( fn:substring(producto.tipo, 0, 3))}"></c:out>"><c:out value="${producto.tipo}"></c:out></span></td>
									<td class="float-end font-weight-normal text-center">
										<p class="mb-1">
											$<c:out value="${producto.costo}"></c:out><span class="text-muted">/<c:out value="${producto.tiempo}"></c:out> hs</span>
										</p>
									</td>

								</tr>
							</c:forEach>
	
							</tbody>
						</table>
					</div>
					<hr />
					<div class="d-flex justify-content-between">

						<a class="btn btn-link link-info p-md-1 my-1"
							data-mdb-toggle="collapse" href="#collapseContent1" role="button"
							aria-expanded="false" aria-controls="collapseContent1">Ver
							detalle</a>
						<button class="btn btn-primary">
							<i class="fas fa-feather"></i> Imprimir
						</button>
					</div>
				</div>
			</div>

		</section>
	</main>

</body>
</html>
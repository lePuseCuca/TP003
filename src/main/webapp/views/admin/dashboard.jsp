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
		<!-- Tabs navs -->
		<ul class="nav nav-tabs mb-3" id="ex1" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="ex1-tab-1" data-mdb-toggle="tab"
				href="#ex1-tabs-1" role="tab" aria-controls="ex1-tabs-1"
				aria-selected="true"><i class="fas fa-map-marker-alt"></i>
					Atracciones</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="ex1-tab-2" data-mdb-toggle="tab" href="#ex1-tabs-2" role="tab"
				aria-controls="ex1-tabs-2" aria-selected="false"><i
					class="fas fa-piggy-bank"></i> Promociones</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="ex1-tab-3" data-mdb-toggle="tab" href="#ex1-tabs-3" role="tab"
				aria-controls="ex1-tabs-3" aria-selected="false"><i
					class="fas fa-user"></i> Usuarios</a></li>
		</ul>
		<!-- Tabs navs -->

		<!-- Tabs content -->
		<div class="tab-content" id="ex1-content">
			<div class="tab-pane fade show active" id="ex1-tabs-1"
				role="tabpanel" aria-labelledby="ex1-tab-1">
				<h3>
					Atracciones <a class="btn btn-primary btn-lg btn-floating"
						style="background-color: #ac2bac;"
						href="/TP003-LPC/atraccion/new.do" role="button"><i
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
								<td><span
									class="badge rounded-pill pill-<c:out value="${fn:substring(fn:toLowerCase(atraccion.tipo), 0, 3)}"></c:out>">
										<c:out value="${atraccion.tipo}"></c:out>
								</span></td>
								<td><a href="#" title="Editar"><i
										class="fas fa-pen-square fs-4 text-warning"></i> </a> <a
									href="/TP003-LPC/attractions/delete?id=<c:out value="${atraccion.id}"></c:out>">
										<c:choose>
											<c:when test="${atraccion.disponible=='1'}">
												<i title="Cargar"
													class="fas fa-arrow-circle-up fs-4 text-success"></i>
											</c:when>
											<c:otherwise>
												<i title="Borrar"
													class="fas fa-minus-square fs-4 text-danger"></i>
											</c:otherwise>
										</c:choose>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="tab-pane fade" id="ex1-tabs-2" role="tabpanel"
				aria-labelledby="ex1-tab-2">
				<h3>
					Promociones <a class="btn btn-primary btn-lg btn-floating"
						style="background-color: #ac2bac;" href="#!" role="button"><i
						class="fas fa-plus"></i></a>
				</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<td>ID</td>
							<td>TIPO PROMOCION</td>
							<td>NOMBRE</td>
							<td>ATRACCIONES</td>
							<td>COSTO</td>
							<td>DESCUENTO</td>
							<td>TIPO</td>
							<td>OPCIONES</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${promociones}" var="promocion">
							<tr>
								<td><b><c:out value="${promocion.id}"></c:out></b></td>
								<td><c:out value="${promocion.tipoPromocion}"></c:out></td>
								<td><c:out value="${promocion.nombre}"></c:out></td>
								<td><c:forEach items="${promocion.atracciones}" var="atr">
										<span
											class="badge rounded-pill pill-<c:out value="${fn:substring(fn:toLowerCase(atr.tipo), 0, 3)}"></c:out>"><c:out
												value="${atr.nombre}"></c:out></span>
										<br>
									</c:forEach></td>
								<td>$ <c:out value="${promocion.costo}"></c:out></td>
								<td>Descuento?</td>
								<td><span
									class="badge rounded-pill pill-<c:out value="${fn:substring(fn:toLowerCase(promocion.tipo), 0, 3)}"></c:out>">
										<c:out value="${promocion.tipo}"></c:out>
								</span></td>
								<td><a href="#" title="Editar"><i
										class="fas fa-pen-square fs-4 text-warning"></i> </a> <a href="#"
									title="Borrar"><i
										class="fas fa-minus-square fs-4 text-danger"></i></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="tab-pane fade" id="ex1-tabs-3" role="tabpanel"
				aria-labelledby="ex1-tab-3">
				<h3>
					Usuarios <a class="btn btn-primary btn-lg btn-floating"
						style="background-color: #ac2bac;" href="#!" role="button"><i
						class="fas fa-plus"></i></a>
				</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<td>FOTO</td>
							<td>NOMBRE</td>
							<td>MONEDAS</td>
							<td>TIEMPO</td>
							<td>TIPO PREFERIDO</td>
							<td>ADMIN</td>
							<td>OPCIONES</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="usuario">
							<tr>
								<td><img
									src="/TP003-LPC/assets/img/<c:out value="${fn: toLowerCase(usuario.nombre)}"></c:out>.jpg"
									class="avatar" /></td>
								<td><b><c:out value="${usuario.nombre}"></c:out></b></td>
								<td>$ <c:out value="${usuario.monedas}"></c:out></td>
								<td><c:out value="${usuario.tiempo}"></c:out> hs.</td>
								<td><span
									class="badge rounded-pill pill-<c:out value="${fn:toLowerCase(fn:substring(usuario.tipoPreferido, 0, 3))}"></c:out>">
										<c:out value="${usuario.tipoPreferido}"></c:out>
								</span></td>

								<td><c:choose>
										<c:when test="${usuario.admin}">
											SI
										</c:when>
										<c:otherwise>
											NO
										</c:otherwise>
									</c:choose></td>

								<td><a
									href="/TP003-LPC/itinerario.do?usuarioId=<c:out value="${usuario.nombre}"></c:out>"
									title="Ver itinerario de <c:out value="${usuario.nombre}"></c:out>"><i
										class="far fa-map fs-4 text-info"></i> </a> <a href="#"
									title="Editar"> <i
										class="fas fa-pen-square fs-4 text-warning"></i>
								</a> <a href="#" title="Borrar"><i
										class="fas fa-minus-square fs-4 text-danger"></i></a></td>
							</tr>
						</c:forEach>
						<!-- tr>
							<td><img src="/TP003-LPC/assets/img/bilbo.jpg" class="avatar" /></td>
							<td><b>Bilbo</b></td>
							<td>$ 200</td>
							<td>10 hs.</td>
							<td><span class="badge rounded-pill pill-pai">
									PAISAJE</span></td>

							<td>NO</td>

							<td><a href="#" title="Ver itinerario de Bilbo"><i class="far fa-map fs-4 text-info" ></i> </a>
									<a href="#" title="Editar"><i class="fas fa-pen-square fs-4 text-warning"></i> </a> 
									<a href="#" title="Borrar"><i class="fas fa-minus-square fs-4 text-danger"></i></a></td>
						</tr>
						<tr>
							<td><img src="/TP003-LPC/assets/img/radagast.jpg" class="avatar" /></td>
							<td><b>Radagast</b></td>
							<td>$ 100</td>
							<td>2 hs.</td>
							<td><span class="badge rounded-pill pill-deg">
									DEGUSTACION</span></td>

							<td>NO</td>

							<td><a href="#" title="Ver itinerario de Radagast"><i class="far fa-map fs-4 text-info"></i> </a>
									<a href="#" title="Editar"><i class="fas fa-pen-square fs-4 text-warning"></i> </a> 
									<a href="#" title="Borrar"><i class="fas fa-minus-square fs-4 text-danger"></i></a></td>
						</tr-->
					</tbody>
				</table>
			</div>
		</div>
		<!-- Tabs content -->



	</main>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-white bg-dark fixed-top">
	<!-- Container wrapper -->
	<div class="container-fluid">
		<a class="navbar-brand mt-2 mt-lg-0" href="#"> <img
			src="<%= request.getContextPath() %>/assets/img/logoTTM.png" height="25" alt="" loading="lazy" /> <span
			class="logo"> Tierra Media</span>
		</a>
		<!-- Collapsible wrapper -->
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<!-- Navbar brand -->


		</div>
		<!-- Collapsible wrapper -->

		<!-- Right elements -->
		<div class="d-flex align-items-center">
			<!-- Icon -->
			<div class="text-reset me-3">
				<span><i class="fas fa-coins"></i> </span> <span
					class="badge badge-pill bg-info"> $<c:out value="${usuario.monedas}"></c:out></span> <span><i
					class="fas fa-clock"></i> </span> <span class="badge badge-pill bg-info">
					<c:out value="${usuario.tiempo}"></c:out> hs</span>

				<!--span class="badge badge-pill bg-warning text-dark"><i class="fas fa-coins"></i> $ 50.-</span>
                        <span class="badge badge-pill bg-info"><i class="fas fa-clock"></i> 2.5 hs.</span-->
			</div>

			<!-- Avatar -->
			<a class="dropdown-toggle d-flex align-items-center hidden-arrow"
				href="#" id="navbarDropdownMenuLink" role="button"
				data-mdb-toggle="dropdown" aria-expanded="false"> <img
				src="<%= request.getContextPath() %>/assets/img/<c:out value='${usuario.nombre.toLowerCase()}'></c:out>.jpg" class="avatar" height="32"
				alt="" loading="lazy" />
			</a>
			<ul class="dropdown-menu dropdown-menu-end"
				aria-labelledby="navbarDropdownMenuLink">
				 
				 <li><span class="dropdown-item text-center fs-5"><c:out value='${usuario.nombre}'></c:out></span></li>
				 <li><hr class="dropdown-divider" /></li>
				<li><a class="dropdown-item" href="#"><i
						class="fas fa-map text-secondary"></i> Itinerario</a></li>
				<li>
                            <a class="dropdown-item" href="#"><i class="fas fa-user-circle"></i> Mi perfil</a>
                        </li>
				<li><a class="dropdown-item" href="<%= request.getContextPath() %>/logout"><i
						class="fas fa-times-circle text-danger"></i> Salir</a></li>
			</ul>
		</div>
		<!-- Right elements -->
	</div>
	<!-- Container wrapper -->
</nav>


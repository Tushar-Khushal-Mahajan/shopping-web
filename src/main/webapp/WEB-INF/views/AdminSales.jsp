<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="startur.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>SALES</title>

<style>
body {
	background-color: #fbfbfb;
	overflow: hidden;
}

@media ( min-width : 991.98px) {
	main {
		padding-left: 240px;
	}
}

/* Sidebar */
.sidebar {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	padding: 58px 0 0; /* Height of navbar */
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 5%), 0 2px 10px 0 rgb(0 0 0/ 5%);
	width: 240px;
	z-index: 600;
}

@media ( max-width : 991.98px) {
	.sidebar {
		width: 100%;
	}
}

.sidebar .active {
	border-radius: 5px;
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 16%), 0 2px 10px 0 rgb(0 0 0/ 12%);
}

.sidebar-sticky {
	position: relative;
	top: 0;
	height: calc(100vh - 48px);
	padding-top: 0.5rem;
	overflow-x: hidden;
	overflow-y: auto;
	/* Scrollable contents if viewport is shorter than content. */
}

.background {
	background-color: #09192A !important;
	color: white !important;
	/* border-bottom: 1px solid white !important; */
}

.body-color {
	background-color: #E5EBF2;
}
</style>
</head>
<body>
	<!--Main Navigation-->
	<header>
		<!-- Sidebar -->
		<nav id="sidebarMenu"
			class="collapse d-lg-block sidebar collapse bg-white background">
			<div class="position-sticky">
				<div class="list-group list-group-flush mx-3 mt-4">
					<a href="homePage"
						class="list-group-item list-group-item-action py-2 ripple background"
						aria-current="true"> <i class="fa fa-tachometer"
						aria-hidden="true"></i> <span>Main dashboard</span>
					</a><a href="productForm"
						class="list-group-item list-group-item-action py-2 ripple background"
						aria-current="true"> <i class="fa fa-plus-circle"
						aria-hidden="true"></i> <span>Add Products</span>
					</a> <a href="orders"
						class="list-group-item list-group-item-action py-2 ripple background "><i
						class="fa fa-shopping-cart" aria-hidden="true"></i> <span>Orders</span></a>
					<!-- <a href="users"
						class="list-group-item list-group-item-action py-2 ripple background"><i
						class="fa fa-users" aria-hidden="true"></i> <span>Users</span></a> -->
					<!--  <a
						href="sales"
						class="list-group-item list-group-item-action py-2 ripple active "><i
						class="fa fa-line-chart" aria-hidden="true"></i> <span>Sales</span></a> -->
					<a
						href="logOut"
						class="list-group-item list-group-item-action py-2 ripple background"><i
						class="fa fa-sign-out" aria-hidden="true"></i> <span>Log
							Out</span></a>
				</div>
			</div>
		</nav>
		<!-- Sidebar -->

		<!-- Navbar -->
		<nav id="main-navbar"
			class="navbar navbar-expand-lg text-white fixed-top"
			style="background-color: #09192A !important;">
			<!-- Container wrapper -->
			<div class="container-fluid">
				<!-- Toggle button -->
				<button class="navbar-toggler" type="button"
					data-mdb-toggle="collapse" data-mdb-target="#sidebarMenu"
					aria-controls="sidebarMenu" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fa fa-bars text-white" aria-hidden="true"></i>
				</button>

				<!-- USER -->
				<h2>TUSHAR</h2>

				<div style="border-radius: 50%; border: 1px solid white !important;">

					<ul class="navbar-nav ms-auto d-flex flex-row">

						<!-- Avatar -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle hidden-arrow text-white d-flex align-items-center"
							href="#" role="button" data-toggle="modal"
							data-target="#adminModal" aria-expanded="false"> <span><i
									class="fa fa-user-o" aria-hidden="true"></i></span>

						</a></li>

					</ul>
				</div>
			</div>
			<!-- Container wrapper -->
		</nav>
		<!-- Navbar -->
	</header>
	<!--Main Navigation-->

	<!--Main layout-->
	<main style="margin-top: 58px; height: 100vh;" class="body-color">
		<div class="container pt-4 body-color">
			<%@include file="model.jsp"%>
			<h1>hey hello</h1>
		</div>
	</main>
	<!--Main layout-->
</body>
</html>
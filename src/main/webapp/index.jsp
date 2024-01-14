<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">



<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Login / Register</title>

<style>
.gradient-custom-2 {
	/* fallback for old browsers */
	background: #fccb90;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593);
}

@media ( min-width : 768px) {
	.gradient-form {
		height: 100vh !important;
	}
}

@media ( min-width : 769px) {
	.gradient-custom-2 {
		border-top-right-radius: .3rem;
		border-bottom-right-radius: .3rem;
	}
}
</style>
</head>
<body>
	<section class="h-100 gradient-form" style="background-color: #eee;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black">
						<div class="row g-0">
							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">

									<div class="text-center">
										<img
											src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
											style="width: 185px;" alt="logo">
										<h4 class="mt-1 mb-5 pb-1">We are The Lotus Team</h4>
									</div>

									<form id="login-form" action="Login" method="post">
										<p>Please login to your account</p>

										<div class="form-outline mb-4">
											<input type="text" id="form2Example11" class="form-control"
												placeholder="email address" name="email" /> <label
												class="form-label" for="form2Example11">Email</label>
										</div>

										<div class="form-outline mb-4">
											<input type="password" id="form2Example22"
												class="form-control" name="password" /> <label
												class="form-label" for="form2Example22">Password</label>
										</div>

										<div class="text-center pt-1 mb-5 pb-1">
											<input type="submit" value="Log in"
												class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" />
											<a class="text-muted" href="#!">Forgot password?</a>
										</div>
									</form>
									<form id="register-form" action="Register" method="post">
										<p>Please register to your account</p>

										<div class="form-outline mb-2">
											<input type="text" id="form3Example22" class="form-control"
												placeholder="Full name" name="name" /> <label
												class="form-label" for="form3Example22">Username</label>
										</div>
										<div class="form-outline mb-2">
											<input type="email" id="form2Example12" class="form-control"
												placeholder="Email" name="email" /> <label
												class="form-label" for="form2Example12">Email</label>
										</div>

										<div class="form-outline mb-2">
											<input type="number" id="form2Example13" class="form-control"
												placeholder="Mobile Number" name="mono" /> <label
												class="form-label" for="form2Example13">Mobile No.</label>
										</div>

										<div class="form-outline mb-2">
											<input type="password" id="form2Example23"
												class="form-control" name="password" /> <label
												class="form-label" for="form2Example23">Password</label>
										</div>

										<div class="text-center pt-1 mb-3 pb-1">
											<input type="submit" value="Register"
												class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" />
										</div>
									</form>
									<div
										class="d-flex align-items-center justify-content-center pb-4">
										<p class="mb-0 me-2" id="bottom-msg"></p>
										<button type="button" id="bottom-btn"
											class="btn btn-outline-danger"></button>
									</div>

								</div>
							</div>
							<div class="col-lg-6 d-flex align-items-center gradient-custom-2">
								<div class="text-white px-3 py-4 p-md-5 mx-md-4">
									<h4 class="mb-4">We are more than just a company</h4>
									<p class="small mb-0">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit, sed do eiusmod tempor incididunt
										ut labore et dolore magna aliqua. Ut enim ad minim veniam,
										quis nostrud exercitation ullamco laboris nisi ut aliquip ex
										ea commodo consequat.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

	<script>
		$().ready(()=>{
			
			function createLogin(){
				$("#bottom-msg").text("Don't have an account?");
				$("#bottom-btn").text("Create new");
				$("#register-form").hide();
			}
			
			createLogin();
			
			
			$("#bottom-btn").on("click",()=>{
				$("#register-form").toggle();
				$("#login-form").toggle();
				
				
				if($("#bottom-btn").text()=="Create new"){
					$("#bottom-msg").text("Already have an account?");
					$("#bottom-btn").text("Login");
				} 
				else{
					$("#bottom-msg").text("Don't have an account?");
					$("#bottom-btn").text("Create new");
				}
			})
		});
	</script>
</body>
</html>
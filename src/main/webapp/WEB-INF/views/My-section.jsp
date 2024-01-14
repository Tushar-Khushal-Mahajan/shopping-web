<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="startur.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>My-Section</title>

<style>
body {
	background-color: #FFFAF0;
}

table tr td {
	text-align: left !important;
}

input, textarea {
	width: 500px;
}
</style>
</head>
<body>

	<%@include file="Nav.jsp"%>

	<!-- USER FORM -->
	<div class="card text-center">

		<div class="card-body">
			<h5 class="card-title">Personal Details</h5>


			<div class="container table-container">


				<div class="alert alert-danger" role="alert" id="update-alert">Update
					Successfully</div>


				<table class="table">
					<tr>
						<th><label for="name">Name :</label></th>
						<td><input type="text" name="name"
							value='${customer.getName()}' id="name"></td>
					</tr>
					<tr>
						<th><label for="email">Email :</label></th>
						<td><input type="email" name="email"
							value="${customer.getEmail()}" id="email" /></td>
					</tr>
					<tr>
						<th><label for="mono">Mo No :</label></th>
						<td><input type="number" name="mono"
							value='${customer.getMono()}' id="mono" /></td>
					</tr>
					<tr>
						<th><label for="address">Address</label></th>
						<td><textarea rows="3" id="address" name="address" cols="25">${customer.getAddress()}</textarea></td>
					</tr>
				</table>
				<button class="btn btn-primary" onClick="update()">Update</button>
			</div>
		</div>
		<!-- <div class="card-footer text-muted">Info update on : 2 days ago</div> -->
	</div>
	<!-- /CLOSE USER FORM -->

	<!--  ORDERS DIV -->
	<div class="card mt-5">
		<div class="card-body">
			<h5 class="card-title">Your Orders</h5>

			<table class="table p-5">
				<tr>
					<th scope="col">Product Name</th>
					<th scope="col">Product Price</th>
					<th scope="col">Order Date</th>
					<th scope="col">Product Detail</th>
				</tr>
			</table>

			<a href="#" class="btn btn-primary">Show All</a>
		</div>
	</div>
	<!-- /CLOSE ORDERS DIV -->
	<script>
		
	//-- initially hide the update alert message..
		$("#update-alert").hide();
	
		/*
		* update() - FUNCTION IS CALLED WHEN UPDASTE BTN PRESSED <br/>
		* IT IS RESPONSIBLE FOR UPDATE THE USER DATAILS..
		*/
		function update() {
			let name = $("#name").val();
			let email = $("#email").val();
			let mono = $("#mono").val();
			let address = $("#address").val();

			//alert("btn click" + name + email + mono + address);

			$.ajax({
				type : "post",
				url : "updateCustomer",
				data : {
					"name" : name,
					"email" : email,
					"mono" : mono,
					"address" : address
				},
				success : function(responce) {
					//alert("update success");
					$("#update-alert").show();
					
					setTimeout(()=>{
						$("#update-alert").hide();
					}, 3000);
				}
			});

		}
	</script>

</body>
</html>
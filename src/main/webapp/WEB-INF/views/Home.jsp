<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Home</title>

<%@include file="startur.jsp"%>

</head>
<body>

	<%@include file="Nav.jsp"%>

	<div class="row">

		<div class="col-md-12">

			<div class="card-columns">

				<!-- traversing products -->
				<c:forEach items="${pdList}" var="product">

					<div class="card m-2 ms-2">
						<div class="container mt-2 text-center" style="overflow: hidden;">
							<img class="card-img-top"
								style="max-height: 200px; max-width: 300px; width: auto;"
								src="<c:url value="/resources/images/${product.getImgPath()}" />"
								alt="Card image cap">
						</div>
						<div class="card-body">

							<h5 class="card-title">${product.getpName() }</h5>

							<p class="card-text">${product.getpDesc() }</p>

							<p class="card-text h6">&#8377; ${product.getpPrice() }</p>

						</div>

						<div class="card-footer">
							<%-- <form action="productBuy/${product.getpId()}" method="post">
								<input type="submit" class="btn btn-success" value="BUY NOW"
									name="pId" />
							</form> --%>

							<!-- START MODEL -->

							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#buymodel${product.getpId()}">BUY NOW</button>

							<!-- Modal -->
							<div class="modal fade" id="buymodel${product.getpId()}"
								tabindex="-1" role="dialog"
								aria-labelledby="exampleModalLongTitle" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLongTitle">PRODUCT
												DETAILS</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<div class="alert alert-warning alert-dismissible fade show"
												role="alert" class="alert_box" style="display: none;"
												id="alert${product.getpId()}">
												<strong>Note!</strong> Product QTY will be 1 to 10.
												<!-- <button type="button" class="close" data-dismiss="alert"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button> -->
											</div>
											<div class="container">
												<p class="h6">
													Product Name : <span>${product.getpName()}</span>
												</p>

												<br />

												<h5>Product Description :</h5>
												<p>${product.getpDesc()}</p>

												<br />

												<h5>Product Price :</h5>
												<p>${product.getpPrice() }</p>

												<br /> <br />
												<hr />

												<h5>Buy Qty</h5>
												<label for="qty${product.getpId()}">select Qty.</label> <input
													type="number" id="qty${product.getpId()}" value="1" />
												<button
													onclick="generatePrice(${product.getpId()},${product.getpPrice()})">Generate
													Price</button>
												<small class="form-text text-muted">Minimum 1 to Max
													10 qty allowed.</small>

												<div id="table${product.getpId()}" style="display: none;">

													<table style="float: right;" cellpadding="5">
														<tr>
															<th>Price(1) :</th>
															<td id="tablePrice${product.getpId()}"></td>
														</tr>

														<tr style="border-bottom: 1px solid black">
															<th>Qty :</th>
															<td id="tableQty${product.getpId()}"></td>
														</tr>

														<tr>
															<th>Total :</th>
															<td id="tableTotal${product.getpId()}"></td>
														</tr>
													</table>
													<small class="form-text text-muted text-warning">Cash
														on delivery is available <br /> online payment option
														comming soon .
													</small>
												</div>
											</div>
										</div>
										<div class="modal-footer" id="cardfooter${product.getpId()}"
											style="display: none;">
											<button type="button" class="btn btn-secondary close-btn"
												data-dismiss="modal">Close</button>
											<button type="button"
												onclick="buy(${product.getpId()},'${product.getpName()}','${product.getpDesc()}',${product.getpPrice()},${cId})"
												class="btn btn-primary">BUY</button>
										</div>
									</div>
								</div>
							</div>

							<!-- END MODEL -->
						</div>

					</div>

					<!-- end tranversing -->
				</c:forEach>

			</div>

		</div>

	</div>

	<!-- START SRCRIPT  -->
	<script>
		var pQty, totalPrice;
	
			function generatePrice(id, price1){
				let qty = +$("#qty"+id).val();
				pQty = qty;

				let price = +price1;
				totalPrice = qty*price;
				
				/* ==DEFAULT SETTING== */
				$("#table"+id).hide();
				$("#cardfooter"+id).hide();
				$("#qty"+id).attr("readonly",false);
				/*  ============= */
				
				if(qty <= 0 || qty >= 11){
					$("#alert"+id).show();
					$("#table"+id).hide();
					$("#cardfooter"+id).hide();
					$("#qty"+id).attr("readonly",false);
				}else{
					$("#alert"+id).hide();
					$("#table"+id).show();
					$("#cardfooter"+id).show();
					$("#qty"+id).attr("readonly",true);
					
					/* ==SET TABLE CONTENT== */
					$("#tablePrice"+id).text(price);
					$("#tableQty"+id).text(qty);
					$("#tableTotal"+id).text(totalPrice);
				}
			}
			
			function buy(id,name,desc, price, custId){
				console.log(id,name,desc,price,pQty,totalPrice);
				 $.ajax({
					type: "post",
					url : "buyWait",
					data : {
								'cId': custId ,
								'pId' : id,
								'pName' : name,
								'pDesc' : desc,
								'price' : price,
								'pQty' : pQty,
								'totalPrice' : totalPrice,
								'isConfirm' : false
						   },
					success : function(responce){
						console.log(responce);
						alert("Product Save");
						$("close-btn").click();
					},
					
				});  
				
				
			}
	</script>
</body>
</html>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tr>
	<th>Ord. ID</th>
	<th>Product</th>
	<th>Description</th>
	<th>Qty</th>
	<th>Total</th>
	<th>Btn</th>
</tr>
<c:forEach items="${confirmOrders}" var="pOrder">
	<tr>
		<td>${pOrder.getoId()}</td>
		<td>${pOrder.getpName()}</td>
		<td>${pOrder.getpDesc()}</td>
		<td>${pOrder.getpQty()}</td>
		<td>${pOrder.getTotalPrice()}</td>
		<td>
			<button class="btn btn-primary"
				onClick="delivered(${pOrder.getoId()})">Delivered</button>
		</td>
	</tr>
</c:forEach>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<c:import url="common/header.jsp"></c:import>
<body>
	<c:import url="common/validation.jsp"></c:import>
	<c:import url="common/nav.jsp"></c:import>
	<section id="main_content" class="w3-main w3-padding w3-content">
		<h2>
			<span class="fa fa-book"></span> Bill
		</h2>
		<div class="w3-responsive">
			<table class="w3-table w3-border">
				<tr class="w3-center w3-theme-l1">
					<th class="w3-center">Name</th>
					<th class="w3-center">Price</th>
					<th class="w3-center">Quantity</th>
					<th class="w3-center">Total</th>
				</tr>
				<c:forEach var="bill" items="${recordList}">
					<tr>
						<td class="w3-center">${bill.food_item.name}</td>
						<td class="w3-center">${bill.food_item.price}KS</td>
						<td class="w3-center">${bill.quantity}</td>
						<td class="w3-center">${bill.quantity * bill.food_item.price}
							KS</td>
					</tr>
				</c:forEach>
				<tr class="w3-border">
					<td class="w3-center" colspan="3">Tax</td>
					<td class="w3-center">${tax}KS</td>
				</tr>
				<tr class="w3-border">
					<td class="w3-center" colspan="3">Total</td>
					<td class="w3-center"><b>${total} KS</b></td>
				</tr>
			</table>
		</div>
	</section>
</body>
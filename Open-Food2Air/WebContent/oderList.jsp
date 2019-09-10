<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<c:import url="common/header.jsp"></c:import>
<body>
	<c:import url="common/validation.jsp"></c:import>
	<c:import url="common/nav.jsp"></c:import>
	<section id="main_content" class="w3-main w3-padding w3-content">
		<h2>
			<span class="fa fa-cart-arrow-down"></span> OrderList
		</h2>
		<c:import url="common/message.jsp"></c:import>
		<div>
			<div
				class="w3-row w3-padding w3-theme-l1 w3-hide-medium w3-hide-small w3-center">
				<div class="w3-large w3-quarter">Name</div>
				<div class="w3-large w3-quarter">Quantity</div>
				<div class="w3-large w3-quarter">Status</div>
				<div class="w3-large w3-quarter">Action</div>
			</div>

			<c:if test="${null != list }">
				<c:forEach var="bill" items="${list}">
					<div
						class="w3-row w3-padding w3-border-bottom w3-hide-medium w3-hide-small w3-center">
						<div class="w3-large w3-quarter">
							<img
								src="${applicationProperties.mediaServer}${bill.food_item.image_url}"
								alt="img" class="confirm-list-photo" />
							<h3>${bill.food_item.name}</h3>
						</div>
						<div class="w3-large w3-quarter">
							<table class="w3-table w3-center">
								<tr>
									<td>Price</td>
									<td>${bill.food_item.price}KS</td>
								</tr>
								<tr>
									<td>Quantity</td>
									<td>${bill.quantity}</td>
								</tr>
								<tr>
									<td>Total</td>
									<td>${bill.quantity * bill.food_item.price}KS</td>
								</tr>
							</table>
						</div>
						<div class="w3-large w3-quarter">
							<h3>${bill.stringStatus}</h3>
						</div>
						<c:if test="${bill.status == 1}">
							<div class="w3-large w3-quarter">
								<a href="../cancelOrder/${sessionBean.tableNumber}/${bill.id}" class="w3-button w3-theme w3-margin-top"> Cancel
								</a>
							</div>
						</c:if>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</section>
</body>
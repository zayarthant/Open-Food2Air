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
			<c:out value="${item.name} - ${item.price}" />
		</h2>
		<div class="w3-row">
			<div class="w3-half w3-padding w3-center">
				<img class="confirm-photo"
					src='<c:out value="${applicationProperties.mediaServer}${item.image_url}"></c:out>'
					alt="img" />
			</div>
			<div class="w3-half w3-padding w3-center">
				<h3>Description</h3>
				<p>
					<c:out value="${item.description}" />
				</p>
				<form action="../makeOrder/${sessionBean.tableNumber}/${item.id}">
					<input id="confirm_box" type="number" min="1" max="999" value="1" name="quantity"
						class="w3-input w3-border w3-margin-top w3-center" />
					<button class="w3-button w3-margin-top w3-theme-l1">
						<span class="fa fa-check"></span> Confirm Order
					</button>
				</form>
			</div>
		</div>
	</section>
</body>
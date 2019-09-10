<%@page import="com.food2air.entity.FoodTable"%>
<%@page import="com.food2air.controller.SessionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<c:import url="common/header.jsp"></c:import>
<body>

	<c:import url="common/validation.jsp"></c:import>

	<c:import url="common/nav.jsp"></c:import>

	<section id="main_content" class="w3-main w3-padding">
		<h2>
			<span class="fa fa fa-cutlery"></span> Menu
		</h2>

		<c:import url="common/message.jsp"></c:import>

		<div class="w3-row">
			<c:forEach items="${foodList}" var="list">
				<div class="w3-quarter w3-center w3-padding">
					<img class="menu-photo"
						src="${applicationProperties.mediaServer}${list.image_url}"
						alt="photo" />
					<h3>${list.name}</h3>
					<a class="w3-large w3-button w3-theme-l1" href="order/${list.id}"><span
						class="fa fa-cart-plus"></span> ${list.price}</a>
				</div>
			</c:forEach>
		</div>
	</section>

</body>
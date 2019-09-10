<%@page import="com.food2air.controller.SessionBean"%>
<%@page import="com.food2air.entity.AdminUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<c:import url="../common/header.jsp"></c:import>
<body>
	<%
		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("sessionBean");
		AdminUser adminUser = (AdminUser) request.getAttribute("adminUser");
		if (null != sessionBean && null != adminUser && 0 != adminUser.getId()) {
			sessionBean.setAdminUser(adminUser);
		}

		if (null == sessionBean.getAdminUser() || sessionBean.getAdminUser().getId() == 0)
			response.sendRedirect("../admin");
	%>
	<c:import url="../common/nav.jsp"></c:import>
	<section id="main_content" class="w3-main w3-padding w3-content">
		<h2>
			<span class="fa fa-cart-arrow-down"></span> OrderList
		</h2>
		<c:import url="../common/message.jsp"></c:import>
		<div>
			<div
				class="w3-row w3-padding w3-theme-l1 w3-hide-medium w3-hide-small w3-center">
				<div class="w3-large w3-quarter">Name</div>
				<div class="w3-large w3-quarter">Quantity</div>
				<div class="w3-large w3-quarter">Table</div>
				<div class="w3-large w3-quarter">Action</div>
			</div>

			<c:if test="${null != list }">
				<c:forEach var="oder" items="${list}">
					<div
						class="w3-row w3-padding w3-border-bottom w3-hide-medium w3-hide-small w3-center">
						<div class="w3-large w3-quarter">
							<h3>${oder.food_item.name}</h3>
						</div>
						<div class="w3-large w3-quarter">
							<h3>${oder.quantity}</h3>
						</div>
						<div class="w3-large w3-quarter">
							<h3>${oder.food_table.table_number}</h3>
						</div>
						<div class="w3-large w3-quarter">
							<c:if test="${oder.status == 1}">
								<a href="../admin/acceptOder/${oder.id}"
									class="w3-button w3-theme w3-margin-top"> Accept </a>
							</c:if>
							<c:if test="${oder.status == 2}">
								<a href="../admin/completeOder/${oder.id}"
									class="w3-button w3-theme w3-margin-top"> Complete </a>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</section>
</body>
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

		if (null == sessionBean.getAdminUser() || sessionBean.getAdminUser().getId() == 0)
			response.sendRedirect("../admin");
	%>
	<c:import url="../common/nav.jsp"></c:import>
	<section id="main_content" class="w3-main w3-padding w3-content">
		<p>
			<a href="${pageContext.request.contextPath}/admin/billList" class=" w3-theme-l1 w3-button"> <span
				class="fa fa-arrow-left"> </span>
			</a>
		</p>
		<h2>
			<span class="fa fa-book"></span> Bill : Table - ${table_number}
		</h2>
		<div class="w3-responsive">
			<table class="w3-table w3-border">
				<tr class="w3-center w3-theme-l1">
					<th class="w3-center">Name</th>
					<th class="w3-center">Price</th>
					<th class="w3-center">Quantity</th>
					<th class="w3-center">Total</th>
				</tr>
				<c:forEach var="bill" items="${bill.order_record_list}">
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
			<p class="w3-center">
                    <a href="${pageContext.request.contextPath}/admin/confirnBill/${bill.id}" class="w3-button w3-theme-l1"><span class="fa fa-check"></span> Confirm Bill </a>
                </p>
		</div>
	</section>
</body>
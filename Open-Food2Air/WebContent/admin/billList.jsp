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
		<h2>
			<span class="fa fa-book"></span> Bill
		</h2>

		<c:import url="../common/message.jsp"></c:import>

		<div class="w3-responsive">
			<table class="w3-table w3-border">
				<tr class="w3-center w3-theme-l1">
					<th class="w3-center">Table</th>
					<th class="w3-center">Action</th>
				</tr>
				<c:if test="${null != list }">
					<c:forEach var="bill" items="${list}">
						<c:if test="${null != bill.food_table.table_number}">
							<tr class="w3-border-bottom">
								<td class="w3-center">${bill.food_table.table_number}</td>
								<td class="w3-center"><a
									href="../admin/billDetail/${bill.id}"
									class="w3-button w3-theme-l1"> Check</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</section>
</body>
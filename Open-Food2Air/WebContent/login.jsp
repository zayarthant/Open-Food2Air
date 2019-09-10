<%@page import="javax.xml.ws.handler.MessageContext.Scope"%>
<%@page import="com.food2air.controller.SessionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="common/header.jsp"></c:import>
<body>

	<%
		Boolean logout = (Boolean) request.getAttribute("out");
		if (null != logout && logout){
			session.invalidate();
		}

		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("sessionBean");
		if (null != sessionBean && sessionBean.getTableNumber() != 0)
			response.sendRedirect("mainMenu");
	%>

	<c:import url="common/nav.jsp"></c:import>

	<section id="main_content" class="w3-main w3-content w3-border">
		<div class="w3-container w3-theme-l1">
			<h2>Login</h2>
		</div>
		<form class="w3-container w3-padding" action="tableLogin">
			<p>
				<label class="w3-text-theme"><b>Table Number</b></label> <input
					class="w3-input w3-border w3-center" id="confirm_box" required
					name="table_number" type="number" min="1" value="1">
			</p>
			<p class="w3-center">
				<button class="w3-btn w3-theme-l1 w3-center">
					<span class="fa fa-key"></span> Login
				</button>
			</p>
		</form>
		<c:import url="common/message.jsp"></c:import>
	</section>

</body>
</html>

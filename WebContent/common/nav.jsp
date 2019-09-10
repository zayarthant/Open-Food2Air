<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Sidebar (hidden by default) -->
<nav id="slide_bar"
	class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left w3-padding">
	<a href="javascript:void(0)" id="close_btn"
		class="w3-bar-item w3-center w3-theme-l2"> <span
		class="fa fa-arrow-left"></span>
	</a>
	<hr>

	<c:if test="${null != sessionBean.adminUser}">
		<a href="${pageContext.request.contextPath}/admin/oderList"
			class="w3-bar-item w3-hover-text-theme"> <span
			class="fa fa-cart-arrow-down"></span> Ordered List
		</a>
		<hr>
		<a href="${pageContext.request.contextPath}/admin/billList"
			class="w3-bar-item w3-hover-text-theme"> <span class="fa fa-book"></span>
			Bill Request
		</a>
		<hr>
		<a href="${pageContext.request.contextPath}/admin/logout"
			class="w3-bar-item w3-hover-text-theme"> <span
			class="fa fa-sign-out"></span> Logout
		</a>
		<hr>
	</c:if>

	<c:if test="${sessionBean.tableNumber > 0}">
		<a href="${pageContext.request.contextPath}/mainMenu"
			class="w3-bar-item w3-hover-text-theme"> <span
			class="fa fa-cutlery"></span> Menu
		</a>
		<hr>
		<a
			href="${pageContext.request.contextPath}/oderList/${sessionBean.tableNumber}"
			class="w3-bar-item w3-hover-text-theme"> <span
			class="fa fa-cart-arrow-down"></span> Ordered List
		</a>
		<hr>
		<a
			href="${pageContext.request.contextPath}/bill/${sessionBean.tableNumber}"
			class="w3-bar-item w3-hover-text-theme"> <span class="fa fa-book"></span>
			Bill
		</a>
		<hr>
		<a href="${pageContext.request.contextPath}/login?out=true"
			class="w3-bar-item w3-hover-text-theme"> <span
			class="fa fa-sign-out"></span> Logout
		</a>
		<hr>
	</c:if>

	<c:if test="${null == sessionBean.adminUser}">
		<a href="${pageContext.request.contextPath}/about"
			class="w3-bar-item w3-hover-text-theme"> <span
			class="fa fa-question-circle-o"></span> About
		</a>
		<hr>
	</c:if>

	<p class="w3-small w3-center">
		<span class="fa fa-bolt"></span> Version 1.0
	</p>
</nav>

<!-- Top menu -->
<header class="w3-top">
	<div class="w3-theme-l1 w3-xlarge">
		<div id="open_btn" class="w3-button w3-padding-16 w3-left">
			<span class="fa fa-navicon"> </span>
		</div>
		<div class="w3-center w3-padding-16">Open-Food2Air</div>
	</div>
</header>
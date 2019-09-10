<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:if test="${errorMessage!=null && fn:length(errorMessage) > 0}">
	<div class="messages w3-red w3-padding w3-padding-16 w3-margin">
		<span class="w3-right w3-padding-small message_btn">&times;</span> <strong>Error!</strong>
		${errorMessage}
	</div>
</c:if>
<c:if test="${message!=null && fn:length(message) > 0}">
	<div class="messages w3-green w3-padding w3-padding-16 w3-margin">
		<span class="w3-right w3-padding-small message_btn">&times;</span> <strong>Success!</strong>
		${message}
	</div>
</c:if>
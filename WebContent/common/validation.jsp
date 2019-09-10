<%@page import="com.food2air.entity.FoodTable"%>
<%@page import="com.food2air.controller.SessionBean"%>
<%
	SessionBean sessionBean = (SessionBean) request.getAttribute("sessionBean");
	FoodTable foodTable = (FoodTable) request.getAttribute("foodTable");

	if (null != foodTable && null != sessionBean) {
		sessionBean.setTableNumber(foodTable.getTable_number());
		request.removeAttribute("foodTable");
	}

	if (sessionBean.getTableNumber() == 0) {
		response.sendRedirect("../login");
		return;
	}
%>
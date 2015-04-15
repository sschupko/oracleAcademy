<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#header {
	background-color: yellow;
	color: black;
	text-align: right;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 300px;
	width: 100px;
	float: left;
	padding: 5px;
	text-align: left;
}

#logout {
	line-height: 30px;
	background-color: #eeeeee;
	height: 300px;
	width: 100px;
	float: left;
	padding: 5px;
	text-align: right;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
</head>
<body style="background-color: aqua;">
	<div id="header">
		<label>Hello, <c:out value="${user.firstName}" />,
		</label>
		<c:out value="${user.lastName}" />
		<form action="Logout" method="get">
			<input type="submit" name="logoutButton" value="Log Out" />
		</form>
		<form action="UserManager" method="post">
			<input type="submit" name="UserManagementButton" value="User Management" />
		</form>
	</div>
	<div class="logo_and_nav">
		<ul class="header_nav">
			<li><a href="${pageContext.request.contextPath}/pages/about.jsp">
					<span>О НАС</span>
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/pages/catalog.jsp"
				class='active'> <span>ПРОДУКЦИЯ</span>
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/pages/contacts.jsp"> <span>КОНТАКТЫ</span>
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/pages/delivery.jsp"> <span>ДОСТАВКА</span>
			</a></li>
		</ul>
	</div>
</body>
</html>
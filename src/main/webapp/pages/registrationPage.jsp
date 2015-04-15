<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="US-ASCII">
<title>Register Page</title>
</head>
<style>
#header {
	background-color: yellow;
	color: black;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 300px;
	width: 100px;
	float: left;
	padding: 5px;
}

#section {
	width: 350px;
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
<body>
	<h3>Provide all the fields for registration.</h3>
	<form action="Registration" method="post">
		<strong>Login</strong>:<input type="text" name="login"> <font
			color="red"><c:if test="${not empty errors.login}">
            <c:out value="${errors.login}" />
            </c:if> </font> <br> <strong>Password</strong>:<input type="password"
			name="password"> <font color="red"><c:if
				test="${not empty errors.password}">
            <c:out value="${errors.password}" />
            </c:if> </font> <br> <strong>First Name</strong>:<input type="text"
			name="firstName" /> <font color="red"><c:if
				test="${not empty errors.firstName}">
            <c:out value="${errors.firstName}" />
            </c:if> </font> <br> <strong>Last Name</strong>:<input type="text"
			name="lastName"><font color="red"><c:if
				test="${not empty errors.lastName}">
            <c:out value="${errors.lastName}" />
            </c:if> </font><br> <strong>Age</strong>:<input type="text"
			name="age"><br> <strong>Date of birth</strong>:<input
			type="text" name="dob"> <font color="red"><c:if
				test="${not empty errors.dob}">
            <c:out value="${errors.dob}" />
            </c:if> </font><br> <strong>Gender</strong>: <input type="radio"
			name="gender" id="case11" value="Male" checked>Male <input
			type="radio" name="gender" id="case2" value="Female">Female <br>
		<strong>Address</strong><br> <strong>Country</strong>:<input
			type="text" name="country"><br> <strong>City</strong>:<input
			type="text" name="city"><br> <strong>Street</strong>:<input
			type="text" name="street"><br> <strong>Zip code</strong>:<input
			type="text" name="zipCode"><br> <strong>Phone*</strong>:<input
			type="text" name="phone"><br> <strong>Email*</strong>:<input
			type="text" name="email"><br> <input type="submit"
			value="Register">
	</form>
	<br> If you are registered user, please
	<a href="index.jsp">login</a>.
</body>
</html>
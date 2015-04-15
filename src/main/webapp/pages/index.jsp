<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
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
</head>
<body style="background-color: lightgrey">
	<form method="post" action="Login">
		<table border="1">
			<thead>
				<tr>
					<th colspan="2">
						<div id="header">Log in</div>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>User name</td>
					<td><div id="nav"><input type="text" name="login" value="" /></div></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" value="" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
				<tr>
					<td colspan="2">Yet Not Registered!! <a
						href="${pageContext.request.contextPath}/pages/registrationPage.jsp">Register Here</a></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
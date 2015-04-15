<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
<table>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
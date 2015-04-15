<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details Of User</title>
</head>
<body>
    <h3>
        <b>Registration has been completed successfully</b>
    </h3>
    <%
        String login = request.getParameter("login");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String age = request.getParameter("age");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String zip = request.getParameter("zip");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String md5 = (String)request.getAttribute("md5");
        
        out.println("Login Name:" + login);
    %>
     <br>
    <%
        out.println("First Name  :" + firstName);
    %>
    <br>
    <%
        out.println("Last Name  :" + lastName);
    %><br>
    <%
        out.println("Date of birth:" + dob);
    %><br>
    <%
        out.println("Age       :" + age);
    %><br>
    <%
        out.println("Gender   :" + gender);
    %>
    <br>
    <%
        out.println("Country   :" + country);
    %><br>
    <%
        out.println("City      :" + city);
    %><br>
    <%
        out.println("Street    :" + street);
    %><br>
    <%
        out.println("Email    :" + email);
    %><br>
     <%
        out.println("Md5    :" + md5);
    %><br>
 
</body>
</html>
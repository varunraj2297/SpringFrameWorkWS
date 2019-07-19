<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" >
</head>
<body>
        <h1 style="color: red; text-align: center"> Customer Registration</h1>
		<form:form method="POST">
			<%-- commandName="command" --%>
			<%--attribute commandName is optional inside form tag--%>
			<%-- <p>
				<form:errors path="*" />
			</p> --%>
		
		cname      :: <form:input type="text" path="cname" />
			<form:errors path="cname" />
			<br>
		caddrs     :: <form:input type="text" path="caddrs" />
			<form:errors path="caddrs" />
			<br>
		mobileNo   :: <form:input type="text" path="mobileNo" />
			<form:errors path="mobileNo" />
			<br>
		billAmount :: <form:input type="text" path="billAmount" />
			<form:errors path="billAmount" />
			<br>
			<input type="submit" value="Register">
		</form:form>
</body>
</html>
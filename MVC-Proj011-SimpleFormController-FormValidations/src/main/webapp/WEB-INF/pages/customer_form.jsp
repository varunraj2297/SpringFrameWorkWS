<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" >
</head>

<body>
        <h1 style="color: red; text-align: center"> Customer Registration</h1>
		<form:form method="POST" onsubmit="return validate(this)">
			<%-- commandName="command" --%>
			<%--attribute commandName is optional inside form tag--%>
			<%-- <p>
				<form:errors path="*" />
			</p> --%>
		
		cname      :: <form:input type="text" path="cname" />
		    <span id="cname.err"></span>
			<form:errors path="cname" />
			<br>
		caddrs     :: <form:input type="text" path="caddrs" />
			<span id="caddrs.err"></span>
			<form:errors path="caddrs" />
			<br>
		mobileNo   :: <form:input type="text" path="mobileNo" />
			<span id="mobileNo.err"></span>
			<form:errors path="mobileNo" />
			<br>
		billAmount :: <form:input type="text" path="billAmount" />
			<span id="billAmount.err"></span>
			<form:errors path="billAmount" />
			<br>
			<form:hidden path="hbox"/>
			<input type="submit" value="Register">
		</form:form>
		
		<script type="text/javascript" src="js/validations.js">
		</script>
</body>
</html>
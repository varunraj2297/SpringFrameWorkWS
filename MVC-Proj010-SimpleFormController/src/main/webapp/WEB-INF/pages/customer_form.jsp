<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color: red; text-align: center">Customer Registration</h1>
<center>
	<form:form method="POST"><%-- commandName="command" --%><%--attribute commandName is optional inside form tag--%>
		cname      :: <form:input	type="text" path="cname"/> <br>
		caddrs     :: <form:input type="text" path="caddrs"/> <br>
		mobileNo   :: <form:input type="text" path="mobileNo"/> <br>
		billAmount :: <form:input type="text" path="billAmount"/> <br>
		<input type="submit" value="Register">
	</form:form>
</center>
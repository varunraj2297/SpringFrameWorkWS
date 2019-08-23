<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h1 style="color: red; text-align: center">Employees Search</h1>
<center>
	<form:form action="search_emps.htm" method="POST" modelAttribute="empCmd">
		eno   :: <form:input path="eno"/> <br>
		ename :: <form:input path="ename"/> <br>
		desg  :: <form:input path="desg"/> <br>
		salary:: <form:input path="salary"/> <br>
		<input type="submit">
	</form:form>
</center>
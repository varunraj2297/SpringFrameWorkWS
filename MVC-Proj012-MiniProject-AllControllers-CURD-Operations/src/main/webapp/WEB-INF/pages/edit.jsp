<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<h1 style="text-align: center;color: red">Register Nobel Laureate</h1>
<center>
<form:form method="POST" commandName="cmdName">
  nobelId:: <form:input path="nobelId" disabled="true"/><br>
  year:: <form:input path="year"/><br>
  laureate:: <form:input path="laureate"/><br>
  field::<form:input path="field"/><br>
  <input type="submit" value="modify">
</form:form>
</center>
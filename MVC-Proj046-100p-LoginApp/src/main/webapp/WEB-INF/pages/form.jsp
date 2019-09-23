<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<h1 style="color:red;text-align: center">Login App</h1>
<center>
  <form:form method="POST" modelAttribute="loginCmd">
	username::  <form:input path="username"/><br>
	password::  <form:password path="password"/><br>
    <input type="submit" value="login">
  </form:form>
</center>

<c:if test="${!empty result}">
   <h3 style="color: blue;text-align: center ">${result}</h3>
</c:if>

<c:if test="${!empty loginCmd}">
   <h3 style="color: blue;text-align: center ">cmd Data::${loginCmd}</h3>
</c:if>


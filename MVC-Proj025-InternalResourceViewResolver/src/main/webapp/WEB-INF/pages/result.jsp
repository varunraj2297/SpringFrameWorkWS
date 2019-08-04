<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<c:if test="${!empty wishMsg}">
    <h1 style="color:red;text-align: center">${wishMsg}</h1>
</c:if>
<a href="home.htm">home</a>
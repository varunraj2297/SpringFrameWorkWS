<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
    
<!DOCTYPE html>

<a href="home.htm">home</a><br><br>

<c:if test="${!empty operation }">
   <h1 style="color:red;text-align: center">All ${operation}</h1>
</c:if>


<c:choose>
  <c:when test="${!empty locales}">
    <c:forEach var="locale" items="${locales}">
       ${locale}<br>
    </c:forEach>
  </c:when>
</c:choose>



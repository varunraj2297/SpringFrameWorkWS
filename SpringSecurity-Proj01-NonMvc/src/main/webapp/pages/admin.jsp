<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <h1 style="color: red;text-align: center">Admin Page</h1>
    <h3 style="color: blue;text-align: center">
       Logged Username::  <%=request.getUserPrincipal().getName() %></h3>
       
<a href="../index.jsp">home</a><br>

<a href="../logout">logout</a>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<center>
<%
   String countries[]=null;
   countries=(String[])request.getAttribute("countries");
   
   for(String country:countries){
	   out.println(country);%>  <br>
<% 
 }
%>
<a href="index.html">home</a>
</center>

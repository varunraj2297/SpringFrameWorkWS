<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<center>
<%
   String langs[]=null;
   langs=(String[])request.getAttribute("langs");
   
   for(String lang:langs){
	   out.println(lang);%></br>
<%   }
%>
<a href="index.html">home</a>
</center>

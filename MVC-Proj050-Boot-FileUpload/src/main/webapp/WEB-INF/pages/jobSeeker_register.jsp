<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
    
<!DOCTYPE html>

<h1 style="color: red;text-align: center;">Job Portol</h1>
<center>
<form:form method="POST" modelAttribute="cmd" enctype="multipart/form-data">
   jsName::<form:input path="jsName"/><br>
   jsDesg::<form:input path="jsDesg"/><br>
   Resume::<input  type="file" name="resume"/><br>
   Photo ::<input  type="file" name="photo"/><br>
   
   <input type="submit" value="register"/>&nbsp;&nbsp;&nbsp;
   <input type="reset" value="cancel"/>
</form:form>
</center>
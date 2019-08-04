<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<form:form method="POST" commandName="cmdData">
   student id::<form:input path="sid"/><br>
   student name::<form:input path="sname"/><br>
   student dob::<form:input path="dob"/><br>
   student doj::<form:input path="doj"/>
   
   <input type="submit" value="register">
</form:form>
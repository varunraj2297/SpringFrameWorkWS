<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<h1 style="color: red;text-align: center">Registration Form</h1>
<h2 style="color: blue;text-align: center">Form-2</h2>
<center>
<form:form method="POST" commandName="cmdData">
  desg::<form:input path="desg"/><br>
  qlfy::<form:input path="qlfy"/><br>
  salary::<form:input path="salary"/><br>
  
  <input type="submit" name="_target0" value="previous">&nbsp;&nbsp;
  <input type="submit" name="_cancel" value="cancel">&nbsp;&nbsp;
  <input type="submit" name="_target2" value="next">
</form:form>
</center>
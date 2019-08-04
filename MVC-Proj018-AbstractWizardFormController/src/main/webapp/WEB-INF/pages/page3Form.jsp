<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<h1 style="color: red;text-align: center">Registration Form</h1>
<h2 style="color: blue;text-align: center">Form-3</h2>
<center>
<form:form method="POST" commandName="cmdData">
  expSalary::<form:input path="expSalary"/><br>
  hobbies::<form:checkboxes path="hobbies" items="${hobbiesList}"/><br>
  expAge::<form:input path="expAge"/><br>
  
  <input type="submit" name="_target1" value="previous">&nbsp;&nbsp;
  <input type="submit" name="_cancel" value="cancel">&nbsp;&nbsp;
  <input type="submit" name="_finish" value="finish">
</form:form>
</center>
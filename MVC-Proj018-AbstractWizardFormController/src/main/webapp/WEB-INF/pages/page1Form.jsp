<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<h1 style="color: red;text-align: center">Registration Form</h1>
<h2 style="color: blue;text-align: center">Form-1</h2>
<center>
<form:form method="POST" commandName="cmdData">
  name::<form:input path="name"/><br>
  addrs::<form:input path="addrs"/><br>
  gender::<form:radiobuttons path="gender" items="${gendersList}"/><br>
  dob::<form:input path="dob"/><br>
  <input type="submit" value="next" name="_target1" >&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="submit" value="cancel" name="_cancel">
  
</form:form>
</center>
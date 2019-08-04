<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <h1 style="color: red;text-align: center">MultiActionController Example</h1>
<!DOCTYPE html>
<form action="perform.htm" method="POST">
  user id::<input type="text" name="userId"><br>
  user Name::<input type="text" name="userName"><br>
  Address ::<input type="text" name="addrs"><br>
  email::<input type="text" name="email"><br>
  <input name="s1" type="submit" value="insert">
  <input name="s1" type="submit" value="update">
  <input name="s1" type="submit" value="delete">
  <input name="s1" type="submit" value="view">
</form>

<c:if test="${!empty cmdData}">
  command data::${cmdData}
  operation::${operation}
</c:if>

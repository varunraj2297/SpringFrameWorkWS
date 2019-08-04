<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <h1 style="color: red;text-align: center">MultiActionController Example</h1>
<!DOCTYPE html>
<form method="POST" name="frm">
  user id::<input type="text" name="userId"><br>
  user Name::<input type="text" name="userName"><br>
  Address ::<input type="text" name="addrs"><br>
  email::<input type="text" name="email"><br>
  <input type="submit" value="add" onclick="javascript: frm.action='add.htm';">
  <input type="submit" value="modify" onclick="javascript: frm.action='modify.htm';">
  <input type="submit" value="remove" onclick="javascript: frm.action='remove.htm';">
  <input type="submit" value="display" onclick="javascript: frm.action='display.htm';">
</form>

<c:if test="${!empty cmdData}">
  command data::${cmdData}
  operation::${operation}
</c:if>

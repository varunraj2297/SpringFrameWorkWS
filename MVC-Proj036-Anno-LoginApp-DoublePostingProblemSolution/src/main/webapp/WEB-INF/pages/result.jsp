<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<h1 style="color:red;text-align: center">Result Page</h1>
<c:if test="${!empty result}">
   <h3 style="color: blue;text-align: center ">${result}</h3>
</c:if>

<c:if test="${!empty loginCmd}">
   <h3 style="color: blue;text-align: center ">cmd Data::${loginCmd}</h3>
</c:if>
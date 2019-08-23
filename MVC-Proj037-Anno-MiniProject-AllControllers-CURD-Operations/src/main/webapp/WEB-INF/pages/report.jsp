<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:choose>
 <c:when test="${!empty listDTO }">
  <table align="center" border="1" bgcolor="yellow">
    <tr style="color: red">
     <th>SRNO</th>
     <th>NOBELID</th>
     <th>YEAR</th>
     <th>LAUREATE</th>
     <th>FIELD</th>
     <th>OPERATION</th>
    </tr>
   <c:forEach var="dto" items="${listDTO}">
    <tr style="color: blue">
      <td>${dto.srno}</td>
      <td>${dto.nobelId}</td>
      <td>${dto.year}</td>
      <td>${dto.laureate}</td>
      <td>${dto.field}</td>
      <td>
         <a href="edit.htm?id=${dto.nobelId}"><img src="images/editIcon.png" width="30" height="30"></a>
         &nbsp;&nbsp;
         <a href="delete.htm?id=${dto.nobelId}" onclick="return confirm('Are you sure to delete ${dto.nobelId} record?')"><img src="images/deleteIcon.png" width="30" height="30"></a>
      </td> 
    </tr>
   </c:forEach>         
  </table>
 </c:when>
 <c:otherwise>
  <h1 style="color: red;text-align: center">No Records Found</h1>
 </c:otherwise>
</c:choose>
<c:if test="${!empty resultMsg}">
  <h1 style="color:green;text-align: center;">
    ${resultMsg}
  </h1>
</c:if>

<a href="home.htm">home</a>
<br>
<a href="add.htm">add more</a>
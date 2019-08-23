<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<c:choose>
   <c:when test="${!empty lof}">
     
     <table border="1" align="center">
       <tr>
          <td>Select files to download...</td>
       </tr>
       <c:forEach var="f" items="${lof}">
         <tr>
            <td><a href="download.htm?fileName=${f}">${f}</a></td>
         </tr>
       </c:forEach>
     </table>
   </c:when>
   <c:otherwise>
        <h1 style="color:red;text-align: center;">No Files Found to download</h1>  
   </c:otherwise>
</c:choose>

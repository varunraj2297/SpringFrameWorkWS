<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty listRDTO}">
		<h1 style="color: red;text-align: center">Hotel Search Details</h1>
		<table align="center"  border="1" style="color: white;text-align: center;border-color: white" bgcolor="blue" >		
           <tr bgcolor="red">
             <th>Sno</th>
             <th>Hotel Id</th>
             <th>Hotel Name</th>
             <th>Type</th>
             <th>Rating</th>
             <th>Cost</th>
             <th>Location</th>
           </tr>
		 <c:forEach var="hotel" items="${listRDTO}">
            <tr>
              <td>${hotel.sno}</td> 
              <td>${hotel.hotelid}</td> 
              <td>${hotel.hname}</td>
              <td>${hotel.type}</td>
              <td>${hotel.rating}</td>
              <td>${hotel.cost}</td>
              <td>${hotel.location}</td>  
            </tr>   
		 </c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	  <h1 style="color: red;text-align: center;">Hotels Not Found</h1>
	</c:otherwise>
</c:choose>

<a href="home.htm">home</a>
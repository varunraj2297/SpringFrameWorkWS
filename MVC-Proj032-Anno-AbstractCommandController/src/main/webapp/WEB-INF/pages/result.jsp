<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<c:choose>
	<c:when test="${!empty resultListDtos}">
        <h1 style="color: red;text-align: center">Employees Search Details</h1>
		<table align="center"  border="1" style="color: white;text-align: center;border-color: white" bgcolor="blue" >		
           <tr bgcolor="red">
             <th>SNO</th>
             <th>EMPNO</th>
             <th>ENAME</th>
             <th>JOB</th>
             <th>SALARY</th>
             <th>MGR</th>
             <th>DEPTNO</th>
           </tr>
		 <c:forEach var="emp" items="${resultListDtos}">
            <tr>
              <td>${emp.sno}</td>
              <td>${emp.eno}</td> 
              <td>${emp.ename}</td>
              <td>${emp.desg}</td>
              <td>${emp.salary}</td>
              <td>${emp.mgr}</td>
              <td>${emp.deptno}</td>  
            </tr>   
		 </c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	  <h1 style="color: red;text-align: center;">Employees Not Found</h1>
	</c:otherwise>
</c:choose>

<a href="search.htm">home</a>

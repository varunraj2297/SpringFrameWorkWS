<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
  <c:choose>
     <c:when test="${!empty listDtos}">
        <table  align="center" border="1">
           <tr bgcolor="cyan"><th>SNO</th><th>EMPNO</th><th>ENAME</th><th>JOB</th><th>SAL</th><th>DEPTNO</th></tr>
           <c:forEach var="emp" items="${listDtos}">
              <tr bgcolor="red">
                 <td>${emp.sno}</td>
                 <td>${emp.empno}</td>
                 <td>${emp.ename}</td>
                 <td>${emp.job}</td>
                 <td>${emp.sal}</td>
                 <td>${emp.deptno}</td>
              </tr>
           </c:forEach>
        </table>
     </c:when>
     <c:otherwise>
         <h1 style="color: red;text-align: center">No Records Found</h1>
     </c:otherwise>
  
  </c:choose>
  
  <a href="home.htm">home</a>
  
  JavaScript:showPrint()
  
 <script type="text/javascript" lang="javascript">
     showPrint(){
    	 frames.focus();
    	 frames.print();
     }
  </script>
  
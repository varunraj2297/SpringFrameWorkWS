<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%List<Map<String,Object>> empsList=(List<Map<String,Object>>)request.getAttribute("empsList"); 
if(empsList!=null){%>
<table>
 <tr><th>EMPNO</th><th>ENAME</th><th>JOB</th><th>SAL</th></tr>
 <%for(Map map:empsList){ %>
 <tr>
    <td><%=map.get("empno")%></td>
    <td><%=map.get("ename")%></td>
    <td><%=map.get("job")%></td>
    <td><%=map.get("sal")%></td>
 </tr>
   <%} 
  }%>
</table>

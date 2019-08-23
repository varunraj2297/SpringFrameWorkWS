<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<head>
  <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>

	<table border="1" width="100%" height="100%" rows="3" cols="2">
		<tr height="30%">
		   <td colspan="2">
		     <tiles:insertAttribute name="header"/>
		   </td>
		</tr>
		<tr height="60%">
		    <td width="40%">
		     <tiles:insertAttribute name="menu"/>
		   </td>
		   <td width="60%">
		     <tiles:insertAttribute name="body"/>
		   </td>
		</tr>
		<tr height="10%">
		   <td colspan="2">
		     <tiles:insertAttribute name="footer"/>
		   </td>
		</tr>
	</table>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<h1 style="color: red; text-align: center">Employees Search</h1>
<center>
	<form action="search_emps.htm" method="POST">
		eno   :: <input type="text" name="eno"> <br>
		ename :: <input	type="text" name="ename"> <br>
		desg  :: <input type="text" name="desg"> <br>
		salary:: <input type="text" name="salary"> <br>
		<input type="submit">
	</form>
</center>
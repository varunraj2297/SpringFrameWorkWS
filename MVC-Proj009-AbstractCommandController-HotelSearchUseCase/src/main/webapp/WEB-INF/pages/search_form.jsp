<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<h1 style="color: red; text-align: center">Hotels Search</h1>
<center>
	<form action="search_hotels.htm" method="POST">
		Hotel id   :: <input type="text" name="hotelid"> <br>
		Hotel name :: <input type="text" name="hname"> <br>
		Hotel type :: <input type="text" name="type"> <br>
		cost       :: <input type="text" name="cost"> <br>
		<input type="submit" value="search">
	</form>
</center>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<h1 style="color: red;text-align: center">Customer Registration</h1>
<form:form method="POST" commandName="cmd">  <!-- commandName is compulsory here -->
  <p style="color:red">
    <form:errors path="*"/>
  </p>
  Customer Name:: <form:input path="custName"/><br>
  Customer Address:: <form:input path="custAddrs"/><br>
  Gender:: <form:radiobuttons path="gender" items="${gendersList}"/><br>
             
  hobbies:: <form:checkboxes path="hobbies" items="${hobbiesList}"/><br>
  country::<form:select path="country">
             <form:options items="${countriesList}"/>
           </form:select><br>
  products::<form:select path="products" multiple="multiple">
              <form:options items="${productsList}"/>
            </form:select><br>
            <input type="submit" value="register">
</form:form>
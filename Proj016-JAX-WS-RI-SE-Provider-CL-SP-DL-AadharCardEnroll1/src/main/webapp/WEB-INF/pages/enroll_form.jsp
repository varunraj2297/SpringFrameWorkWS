<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<h1 style="color: red;text-align: center">Aadhar Card Enrollment</h1>

<form:form  modelAttribute="aadharCommand" method="POST">
     <table align="center">
          <tr>
              <td>First name::</td>
              <td><form:input path="firstName"/></td>
          </tr>
          <tr>
              <td>Last name::</td>
              <td><form:input path="lastName"/></td>
          </tr>
          <tr>
              <td>Gender::</td>
              <td><form:radiobuttons path="gender" items="${gendersList}" /></td>
          </tr>
          <tr>
              <td>Date of birth::</td>
              <td><form:input path="dob"/> (dd-MM-yyyy)</td>
          </tr>
          <tr>
              <td>Pincode::</td>
              <td><form:input path="pinCode"/></td>
          </tr>
          <tr>
             <td colspan="2"><input type="submit" value="enroll"></td>             
          </tr>
     </table>

</form:form>
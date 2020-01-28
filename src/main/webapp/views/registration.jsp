<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Registration</title>
	</head>
	
	<body>
		<form:form action="/ProfileManagementMvc/profilemanagement/user/registration" modelAttribute="employee" method = "POST">  
			<fieldset>
				<legend>Enter Your Details : </legend>
					<table>
						<tr>
							<td>First Name : </td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td>Last Name : </td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td>Salary : </td>
							<td><form:input path="salary" /></td>
						</tr>
						<tr>
						   <td colspan = "2">
								<input type = "submit" value = "Submit"/>
						   </td>
						</tr>
					</table>
			</fieldset>    
	    </form:form>  
	</body>
	
</html>
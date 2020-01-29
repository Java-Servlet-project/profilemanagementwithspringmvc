<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<!DOCTYPE html>

<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Your Profile</title>
	</head>

	<body>
		<div>
			<p>
				<table>
					<tr>
						<td>First Name : </td>
						<td>${employee.firstName}</td>
					</tr>
					<tr>
						<td>Last Name : </td>
						<td>${employee.lastName}</td>
					</tr>
					<tr>
						<td>Salary : </td>
						<td>${employee.salary}</td>
					</tr>
				</table>
			</p>
		</div>
	</body>
	
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Movie</title>
</head>
<body>
	<h1>Movies Currently Available in Store</h1>
	<table border=1>
		<c:forEach var="movie" items="${movies}">
			<tr>
				<td>${movie.title}</td>
				<td>${movie.year}</td>
				<td>${movie.summary}</td>
				<%-- <td>${movie.poster}</td> --%>
				<td>${movie.comment}</td>
				<td>${movie.genere}</td>
				<td>${movie.rating}</td>
				<td><a href="edit/${movie.id}">Edit</a></td>
				<td><a href="delete/${movie.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
	<a href="addMovie">Add Movie</a>
</body>
</html>
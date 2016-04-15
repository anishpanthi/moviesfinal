<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie</title>
</head>
<body>
	<form action="../movies/addNewMovie" method="post">
		<table>
			<th>Enter Movie Information:</th>
			<tr>
				<spring:bind path="movie.title">
					<td><label>Title:</label></td>
					<td><form:input path="movie.title" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="movie.year">
					<td><label>Year:</label></td>
					<td><form:input path="movie.year" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="movie.summary">
					<td><label>Summary:</label></td>
					<td><form:input path="movie.summary" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="movie.poster">
					<td><label>Poster:</label></td>
					<td><form:input path="movie.poster" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="movie.comment">
					<td><label>Comment:</label></td>
					<td><form:textarea path="movie.comment" rows="5" cols="30" /></td>
				</spring:bind>
			</tr>
			<tr>
				<td>Generes:</td>
				<td><form:select path="movie.genere">
						<form:option value="NONE">Select Movie Genere:</form:option>
						<c:forEach items="${generes}" var="genere">
							<form:option value="${genere}">${genere}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><form:select path="movie.rating">
						<form:option value="NONE">Select Movie Rating:</form:option>
						<c:forEach items="${ratings}" var="rating">
							<form:option value="${rating}">${rating}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<br />
			<th>Enter Artist Information:</th>
			<tr>
				<spring:bind path="artist.firstName">
					<td><label>First Name:</label></td>
					<td><form:input path="artist.firstName" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="artist.lastName">
					<td><label>Last Name:</label></td>
					<td><form:input path="artist.lastName" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="artist.dateOfBirth">
					<td><label>Date of Birth:</label></td>
					<td><form:input path="artist.dateOfBirth" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="artist.placeOfBirth">
					<td><label>Place of Birth:</label></td>
					<td><form:input path="artist.placeOfBirth" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="artist.biography">
					<td><label>Biography:</label></td>
					<td><form:textarea path="artist.biography" rows="5" cols="30" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="artist.picture">
					<td><label>Picture:</label></td>
					<td><form:input path="artist.picture" /></td>
				</spring:bind>
			</tr>
			<br />
			<th>Enter Director Information:</th>
			<tr>
				<spring:bind path="director.firstname">
					<td><label>First Name:</label></td>
					<td><form:input path="director.firstname" /></td>
				</spring:bind>
			</tr>
			<tr>
				<spring:bind path="director.lastname">
					<td><label>Last Name:</label></td>
					<td><form:input path="director.lastname" /></td>
				</spring:bind>
			</tr>
		</table>

		<br /> <input type="submit" value="Create" />
	</form>

	<%-- <form:form method="POST" action="/addNewMovie">

		<form:form modelAttribute="movie">
			<table>
				<tr>
					<th>Enter Movie Information</th>
				</tr>
				<tr>
					<td>Title:</td>

					<td><form:input path="title" /></td>
				</tr>
				<tr>
					<td>Year:</td>
					<td><form:input path="year" /></td>
				</tr>
				<tr>
					<td>Summary:</td>
					<td><form:input path="summary" /></td>
				</tr>
				<tr>
					<td>Poster:</td>
					<td><form:input path="poster" /></td>
				</tr>
				<tr>
					<td>Generes:</td>
					<td><form:select path="generes">
							<c:forEach items="${generes}" var="genere">
								<form:option value="${genere}">${genere}</form:option>
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td>Rating:</td>
					<td><form:select path="rating">
							<form:option value="NONE">Select Movie Rating:</form:option>
							<c:forEach items="${ratings}" var="rating">
								<form:option value="${rating}">${rating}</form:option>
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td>Comment:</td>
					<td><form:textarea path="comment" rows="5" cols="30" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<form:form modelAttribute="artist">
			<table>
				<th>Enter Artist Information</th>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input path="dateOfBirth" /></td>
				</tr>
				<tr>
					<td>Place of Birth:</td>
					<td><form:input path="placeOfBirth" /></td>
				</tr>
				<tr>
					<td>Biography:</td>
					<td><form:textarea path="biography" rows="5" cols="30" /></td>
				</tr>
				<tr>
					<td>Picture:</td>
					<td><form:input path="picture" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<form:form modelAttribute="director">
			<table>
				<th>Enter Director Information</th>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<br />
		<input type="submit" value="Submit" />
	</form:form> --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films</title>

<!-- <link rel = "stylesheet" href = "css.ourStyles.css"> -->

</head>
<body>
	<p><a href="index.html">Home</a></p>
	
	<h2>Films:</h2>
	
	<c:choose>
		<c:when test="${! empty films }">
			<table>
				<thead><th><strong>ID</strong></th><th><strong>Title</strong></th></thead>
				<c:forEach items="${films }" var="film">
					<tr>
					<td>${film.filmId }</td>
					<td>${film.title }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>

		<c:otherwise>
			<p>No films in database.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>
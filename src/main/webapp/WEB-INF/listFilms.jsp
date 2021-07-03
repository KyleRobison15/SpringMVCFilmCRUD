<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Films</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

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
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
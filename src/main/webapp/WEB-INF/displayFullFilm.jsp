<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Film Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
<p><a href="index.html">Home</a></p>

<c:choose>
		<c:when test="${! empty film }">

			<ul>
				
				<%-- <li><strong>ID: </strong>${film.filmId }</li> --%>
				<li><strong>Title: </strong>${film.title }</li>
				<li><strong>Category: </strong>${film.category }</li>
				<li><strong>Rating: </strong>${film.rating }</li>
				<li><strong>Description: </strong>${film.description }</li>
				<li><strong>Release Year: </strong>${film.releaseYear.substring(0,4) }</li>
				<li><strong>Language: </strong>${film.language }</li>
				<li><strong>Actors: </strong><br>
					
						<ol>
							<c:forEach items="${film.actors }" var = "actor">
							<li>${actor.firstName } &nbsp; ${actor.lastName }  </li>
							</c:forEach>
						</ol>
				</li>	
				<li><strong>Length: </strong>${film.length } &nbsp; minutes</li>
				<li><strong>Special Features: </strong>${film.specialFeatures }</li>
				<li><strong>Rental Rate: </strong><fmt:formatNumber value="${film.rentalRate }" type="currency" /></li>
				<li><strong>Rental Duration: </strong>${film.rentalDuration } &nbsp; days</li>
				<li><strong>Replacement Cost: </strong><fmt:formatNumber value="${film.replacementCost }" type="currency" /></li>
				
			</ul>

		</c:when>

		<c:otherwise>
			<p>No film was found.</p>
		</c:otherwise>
	</c:choose>
	
	<form action="editFilm.do">
<%-- 	<input type="hidden" value=${film.id } name="filmId">
 --%>	<input type= "submit" value="Edit" >
	</form>
	<form action="deleteFilm.do">
<%-- 	<input type="hidden" value=${film.id } name="filmId">
 --%>	<input type= "submit" value="Delete" >
	</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
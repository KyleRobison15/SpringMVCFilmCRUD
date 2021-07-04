<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm this is the Film you want to delete:</title>
</head>
<body>
<c:choose>
		<c:when test="${! empty film }">

			<ul>
				
				 <li><strong>ID: </strong>${film.filmId }</li> 
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
	<input type="submit" value="Delete Film" />
</body>
</html>
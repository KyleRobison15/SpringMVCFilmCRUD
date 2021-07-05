<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Edit Film</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
	<p><a href="index.html">Home</a></p>
	
		<h5>Enter the film's NEW details and then click "Update Film" to update it in the database: </h5>
	
				<form class="" action="updateFilm.do" method="POST">
				
				<input name = "id" type = "hidden" value=${film.filmId }>
				<label for="title">Title: </label><input type="text" name="title" value="${film.title }" id="title"><br>
				<label for="rating">Rating: </label><input name = "rating" type ="text" value="${film.rating }" id ="rating"><br>
				<label for="description">Description: </label><input name = "description" type ="text" value ="${film.description }" id ="description"><br>
				<label for="releaseYear">Release Year: </label><input name = "releaseYear" type ="text" value="${film.releaseYear.substring(0,4) }" id ="releaseYear"><br>
				<label for="language">Language: </label><input name = "language" type ="text" value ="${film.language }" id = "language"><br>
				<label for="length">Length: </label><input name = "length" type ="text" value="${film.length }" id = "language"> &nbsp; minutes
<%-- 				<input name ="specialFeatures" value =${film.specialFeatures }>
				<input name = "rentalRate" value =${film.rentalRate }>
				<input name = "rentalDuration" value=${film.rentalDuration } &nbsp; days>
				<input name = "replacementCost" value="${film.replacementCost }" type="currency"> --%>
				
				</form>
				
			<form action="filmUpdated.do" method="POST">
				<input type="hidden" name="id" value="${film.filmId }">
				<input type="submit" value="Confirm and Update" />
			</form>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
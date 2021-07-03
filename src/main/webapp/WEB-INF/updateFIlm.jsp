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
	
					<form class="" action="" method="POST"> <!-- action = "editFilm.do" -->
						<label for="Title">Title: </label><input type="text" name="Title" value="" id="Title"><br>
				 <input name = "id" type = "hidden" value=${film.filmId }>
				<input name = "title" value = ${film.title }>
				<input name = "category" value=${film.category }>
				<input name = "rating" value=${film.rating }>
				<input name = "description" value =${film.description }>
				<input name = "releaseYear" value=${film.releaseYear.substring(0,4) }>
				<input name = "language" value =${film.language }>
				<input name = "actors" value = ${film.actors }>
				<input name = "length" value=${film.length } &nbsp; minutes>
				<input name ="specialFeatures" value =${film.specialFeatures }>
				<input name = "rentalRate" value =${film.rentalRate }>
				<input name = rentalDuration value=${film.rentalDuration } &nbsp; days>
				<input name = "replacementCost" value="${film.replacementCost }" type="currency">
				</form>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
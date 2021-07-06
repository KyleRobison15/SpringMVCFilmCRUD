<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
    
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
				
				</form>
				
				<form class="" action="ConfirmUpdate.do" method="POST">
			<input name = "filmId" type = "hidden" value=${film.filmId } id = "filmId">
			<label for="title">Title: </label><input type="text" name="title" value="${film.title }" id="title"><br>
		
<!-- 		<label for="category">Choose a Category: </label>
			<select id="category" name="category">
    			<option value="Action">Action</option>
    			<option value="Animation">Animation</option>
    			<option value="Children">Children</option>
    			<option value="Classics">Classics</option>
    			<option value="Comedy">Comedy</option>
    			<option value="Documentary">Documentary</option>
    			<option value="Drama">Drama</option>
    			<option value="Family">Family</option>
    			<option value="Foreign">Foreign</option>
    			<option value="Games">Games</option>
    			<option value="Horror">Horror</option>
    			<option value="Music">Music</option>
    			<option value="New">New</option>
    			<option value="Sci-Fi">Sci-Fi</option>
    			<option value="Sports">Sports</option>
    			<option value="Travel">Travel</option>
  			</select><br> -->	
  			
  		<label for="rating">Select a rating: </label><br>
			<input type="radio" id = "rating" name="rating" value="G"> G
			<input type="radio" id = "rating" name="rating" value="PG"> PG
			<input type="radio" id = "rating" name="rating" value="PG13"> PG13
			<input type="radio" id = "rating" name="rating" value="R"> R
			<input type="radio" id = "rating" name="rating" value="NC17"> NC17 <br>

		<label for="description">Description: </label><input type="text" name="description" value="${film.description }" id="description"><br>
		<label for="realeaseYear">Release Year: </label><input type="text" name="releaseYear" value="${fn:substring(film.releaseYear, 0, 4)}" id="releaseYear"><br>
		
	 	 <label for="languageId">Choose a Language: </label>
			<select id="languageId" name="languageId">
    			<option value="1">English</option>
    			<option value="2">Italian</option>
    			<option value="3">Japanese</option>
    			<option value="4">Mandarin</option>
    			<option value="5">French</option>
    			<option value="6">German</option>
    		</select><br>
	 	
		<label for="length">Length (in minutes): </label><input type="text" name="length" value="${film.length }" id="length"><br>
		
		<label for="specialFeatures">Select any special features: </label><br>
			<input type="checkbox" id = "specialFeatures" name="specialFeatures" value="Deleted Scenes" checked> Deleted Scenes
			<input type="checkbox" id = "specialFeatures" name="specialFeatures" value="Commentaries" checked> Commentaries
			<input type="checkbox" id = "specialFeatures" name="specialFeatures" value="Behind the Scenes" checked> Behind the Scenes
			<input type="checkbox" id = "specialFeatures" name="specialFeatures" value="Trailers" checked> Trailers

		<br><label for="rentalRate">Rental Rate: </label><input type="text" name="rentalRate" value="${film.rentalRate }" id="rentalRate"><br>
		<label for="rentalDuration">Rental Duration (in days): </label><input type="text" name="rentalDuration" value="${film.rentalDuration }" id="rentalDuration"><br>
		<label for="replacementCost">Replacement Cost: </label><input type="text" name="replacementCost" value="${film.replacementCost }" id="replacementCost"><br>
		
		<input type="submit" value="Confirm and Update" />
	</form><br/>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
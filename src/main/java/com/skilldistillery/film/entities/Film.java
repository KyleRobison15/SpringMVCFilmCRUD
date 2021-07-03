package com.skilldistillery.film.entities;

import java.text.NumberFormat;
import java.util.List;

public class Film {
	
	private int filmId;
	private String title;
	private String description;
	private String releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private Language language;
	private Category category;
	private List<Actor> actors;
	private List<InventoryItem> filmsInInventory;

	public Film() {
		
	}
	
	public Film(int filmId, String title) {
		this(filmId, title, null, null, 0, 0, 0, 0, 0, null, null, null, null, null, null);
	}
	
	public Film(int filmId, String title, String description, String releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
		this(filmId, title, description, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, null, null, null, null);

	}

	public Film(int filmId, String title, String description, String releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures, 
			Language language, Category category, List<Actor> actors, List<InventoryItem> filmsInInventory) {
		
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.language = language;
		this.category = category;
		this.actors = actors;
		this.filmsInInventory = filmsInInventory;
	}
	
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<InventoryItem> getFilmsInInventory() {
		return filmsInInventory;
	}

	public void setFilmsInInventory(List<InventoryItem> filmsInInventory) {
		this.filmsInInventory = filmsInInventory;
	}

	public void displaySimpleFilmInfo() {
		int count = 1;
		
		System.out.println("Title:         " + title);
		System.out.println(category);
		System.out.println("Rating:        " + rating);
		System.out.println("Description:   " + description);
		System.out.println("Year Released: " + releaseYear.substring(0,4));
		System.out.println(language);
		System.out.println("Actors:        ");
		for (Actor actor : actors) {
			System.out.println(" " + count + ". " + actor);
			count++;
		}
	}
	
	public void displayAllFilmInfo() {
		int count = 1;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		System.out.println("Title:         " + title);
		System.out.println(category);
		System.out.println("Rating:        " + rating);
		System.out.println("Description:   " + description);
		System.out.println("Year Released: " + releaseYear.substring(0,4));
		System.out.println(language);
		System.out.println("Actors:        ");
		for (Actor actor : actors) {
			System.out.println(" " + count + ". " + actor);
			count++;
		}
		
		System.out.println("Length:            " + length + " minutes");
		System.out.println("Speacial Features: " + specialFeatures);
		System.out.println("Rental Rate:       " + formatter.format(rentalRate));
		System.out.println("Rental Duration:   " + rentalDuration + " days");
		System.out.println("Replacement Cost:  " + formatter.format(replacementCost));
	}
	
	public void displayFilmInventory() {
		int newCount = 0;
		int usedCount = 0;
		int totalCount = 0;
		for (InventoryItem item : filmsInInventory) {
			
			if (item.getMediaCondition().equalsIgnoreCase("New")) {
				newCount++;
			}
			else if (item.getMediaCondition().equalsIgnoreCase("Used")) {
				usedCount++;
			}
		}
		totalCount = newCount + usedCount;
		
		
		System.out.println("---- Copies of " + title + " in stock ----");
		System.out.println("New:    " + newCount);
		System.out.println("Used:  " + usedCount);
		System.out.println("Total: " + totalCount);
		System.out.println("---------------------------------------------");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [filmId=").append(filmId).append(", title=").append(title).append(", description=")
				.append(description).append(", releaseYear=").append(releaseYear).append(", languageId=")
				.append(languageId).append(", rentalDuration=").append(rentalDuration).append(", rentalRate=")
				.append(rentalRate).append(", length=").append(length).append(", replacementCost=")
				.append(replacementCost).append(", rating=").append(rating).append(", specialFeatures=")
				.append(specialFeatures).append(", language=").append(language).append(", category=").append(category)
				.append(", actors=").append(actors).append(", filmsInInventory=").append(filmsInInventory).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + filmId;
		result = prime * result + ((filmsInInventory == null) ? 0 : filmsInInventory.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (filmId != other.filmId)
			return false;
		if (filmsInInventory == null) {
			if (other.filmsInInventory != null)
				return false;
		} else if (!filmsInInventory.equals(other.filmsInInventory))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}

package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.InventoryItem;
import com.skilldistillery.film.entities.Language;

public interface FilmDAO {
	public List<Film> getFilms();
	public Film findFilmById(int filmId);
	public Actor findActorById(int actorId);
	public Language findLanguageByFilmId(int filmId);
	public Category findCategoryByFilmId(int filmId);
	public List<InventoryItem> findInventoryByFilmId(int filmId);
	public List<Film> findFilmsByKeyword(String keyword);
	public List<Actor> findActorsByFilmId(int filmId);
	public Film insertFilmToDatabase(Film film) throws SQLException;
	public int updateFilmInDatabase(Film film) throws SQLException;
	public int deleteFilmFromDatabase(Film film) throws SQLException;
}

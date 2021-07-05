package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.InventoryItem;
import com.skilldistillery.film.entities.Language;


public class JDBCFilmDAOImpl implements FilmDAO {
	/* Establish connection to DB and Convert to Maven project
	 add dependencies (modify pom file as needed)*/ 
	
	private static String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";
	
	// Register driver:
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/////////////////////////////////////////////////// FILM ///////////////////////////////////////////////////

	@Override
	public List<Film> getFilms() {
		
	    List<Film> films = new ArrayList<>();
	    
	    try {
	      Connection conn = DriverManager.getConnection(URL, user, pass);
	      
	      String sql = "SELECT * FROM film";
	      PreparedStatement st = conn.prepareStatement(sql);
	      ResultSet rs = st.executeQuery();
	      while(rs.next()) {
	    	  
	    	  Film film = new Film(rs.getInt("id"), rs.getString("title"));
	    	  films.add(film);
	    	  
	      }
	      conn.close();
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
		
		return films;
	}
	
	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				film = createFilmFromQuery(filmResult);
			}

			filmResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				Film film = new Film();
				film = createFilmFromQuery(filmResult);
				films.add(film);
			}

			filmResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return films;
	}

	public Film createFilmFromQuery(ResultSet filmResult) {
		Film film = new Film();

		try {

			film.setFilmId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getString("release_year"));
			film.setLanguageId(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setRating(filmResult.getString("rating"));
			film.setLanguage(findLanguageByFilmId(filmResult.getInt("id")));
			film.setCategory(findCategoryByFilmId(filmResult.getInt("id")));
			film.setActors(findActorsByFilmId(filmResult.getInt("id")));
			film.setFilmsInInventory(findInventoryByFilmId(filmResult.getInt("id")));

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return film;
	}
	
	@Override
	public Film insertFilmToDatabase(Film film) throws SQLException {
		
	    Connection conn = null;
	    String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, "
	    					+ "rental_rate, length, replacement_cost, rating, special_features)"
	    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try {
	      conn = DriverManager.getConnection(URL, user, pass);
	      conn.setAutoCommit(false); // Start transaction
	      
	      PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	      st.setString(1, film.getTitle());
	      st.setString(2, film.getDescription());
	      st.setString(3, film.getReleaseYear());
	      st.setInt(4, film.getLanguageId());
	      st.setInt(5, film.getRentalDuration());
	      st.setDouble(6, film.getRentalRate());
	      st.setInt(7, film.getLength());
	      st.setDouble(8, film.getReplacementCost());
	      st.setString(9, film.getRating());
	      st.setString(10, film.getSpecialFeatures());
	      
	      int uc = st.executeUpdate();
	      
	      if (uc != 1) {
			conn.rollback(); //Error handling in case the INSERT did not work properly
			return null;
		}
	      
	      // Now get the auto-generated film ID and set it:
	      ResultSet keys = st.getGeneratedKeys();
	      
	      //Set the filmId to the auto-generated ID from MySQL
	      int filmId = 0;
	      while (keys.next()) {
	    	  filmId = keys.getInt(1);
	    	  film.setFilmId(filmId);
	      }
	      
	      //Set the film's language name
	     
	      
	      conn.commit();
	      
	      return findFilmById(filmId);
	      
	    }
	    catch (SQLException e) {
	    	conn.rollback();
	      e.printStackTrace();
	    }
	    conn.close();
		return null;
	}
//	TODO refine logic to match update and delete as these methods were copy pasted
	@Override
	public Film updateFilmInDatabase(Film film) throws SQLException {
		
		Connection conn = null;
		String sql = "UPDATE film SET title, description, release_year, language_id, rental_duration, "
				+ "rental_rate, length, replacement_cost, rating, special_features WHERE"
				+ "title, description, release_year, language_id, rental_duration, \"\n"
				+ "				+ \"rental_rate, length, replacement_cost, rating, special_features = ?";
		
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // Start transaction
			
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, film.getTitle());
			st.setString(2, film.getDescription());
			st.setString(3, film.getReleaseYear());
			st.setInt(4, film.getRentalDuration());
			st.setDouble(5, film.getRentalRate());
			st.setInt(6, film.getLength());
			st.setDouble(7, film.getReplacementCost());
			st.setString(8, film.getRating());
			st.setString(9, film.getSpecialFeatures());
			
			int uc = st.executeUpdate();
			System.out.println(uc + " film records created.");
			
			if (uc != 1) {
				System.err.println("Something went wrong"); //Error handling in case the INSERT did not work properly
				conn.rollback(); //Error handling in case the INSERT did not work properly
				return null;
			}
			
			
			// Now get the auto-generated actor IDs:
			ResultSet keys = st.getGeneratedKeys();
			
			int filmId = 0;
			while (keys.next()) {
				filmId = keys.getInt(1);
				System.out.println("New film ID: " + filmId);
			}
			
			conn.commit();
			
			return findFilmById(filmId);
			
		}
		catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
		conn.close();
		return null;
	}
	
	@Override
	public int deleteFilmFromDatabase(Film film) throws SQLException {
		
		Connection conn = null;
		String sql = "DELETE FROM film WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // Start transaction
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, film.getFilmId());
			
			int uc = st.executeUpdate();
			
			if (uc != 1) {
				conn.rollback(); //Error handling in case the DELETE did not work properly
				return 0;
			}
			
			conn.commit();
			
		}
		catch (SQLException e) {
			conn.rollback();
			System.err.println("Cannot delete this record due to child table dependencies.");
			return 0;
		}
		conn.close();
		return 1;
	}
	
/////////////////////////////////////////////////// ACTOR ///////////////////////////////////////////////////

	@Override
	public Actor findActorById(int actorId) {

		Actor actor = null;

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
				actor = new Actor();
				actor.setActorId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));

			}

			actorResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * " + 
						 "FROM actor " + 
						 "JOIN film_actor ON film_actor.actor_id = actor.id " +
						 "JOIN film ON film_actor.film_id = film.id " + 
						 "WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorsResult = stmt.executeQuery();
			while (actorsResult.next()) {

				int actorId = actorsResult.getInt("actor.id");
				String actorFirstName = actorsResult.getString("actor.first_name");
				String actorLastName = actorsResult.getString("actor.last_name");
				Actor actor = new Actor(actorId, actorFirstName, actorLastName);
				actors.add(actor);
			}

			actorsResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return actors;
	}

/////////////////////////////////////////////////// LANGUAGE ///////////////////////////////////////////////////

	@Override
	public Language findLanguageByFilmId(int filmId) {

		Language language = null;

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * " +
						 "FROM language " +
						 "JOIN film ON language.id = film.language_id " +
						 "WHERE film.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet languageResult = stmt.executeQuery();
			while (languageResult.next()) {
				language = new Language();
				language.setId(languageResult.getInt("id"));
				language.setLanguageName(languageResult.getInt("id"));
			}

			languageResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return language;
	}
	
/////////////////////////////////////////////////// CATEGORY ///////////////////////////////////////////////////
	
	@Override
	public Category findCategoryByFilmId(int filmId) {
		
		Category category = null;
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			
			String sql = "SELECT * "
					  +  "FROM category "
					  +  "JOIN film_category ON film_category.category_id = category.id "
					  +  "JOIN film ON film_category.film_id = film.id WHERE film.id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet categoryResult = stmt.executeQuery();
			while (categoryResult.next()) {
				category = new Category();
				category.setCategoryId(categoryResult.getInt("id"));
				category.setCategoryName(categoryResult.getString("name"));
			}
			
			categoryResult.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return category;
	}
	
/////////////////////////////////////////////////// INVENTORY ITEM ///////////////////////////////////////////////////
	
	@Override
	public List<InventoryItem> findInventoryByFilmId(int filmId) {
		
		List<InventoryItem> inventory = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			
			String sql = "SELECT * "
					   + "FROM inventory_item "
					   + "WHERE film_id = ? AND media_condition != 'lost'";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet inventoryResult = stmt.executeQuery();
			while (inventoryResult.next()) {
				int inventoryId = inventoryResult.getInt("inventory_item.id");
				int inventoryFilmId = inventoryResult.getInt("inventory_item.film_id");
				int storeId = inventoryResult.getInt("inventory_item.store_id");
				String mediaCondition = inventoryResult.getString("inventory_item.media_condition");
				String lastUpdate = inventoryResult.getString("inventory_item.last_update");

				InventoryItem item = new InventoryItem(inventoryId, inventoryFilmId, storeId, mediaCondition, lastUpdate);
				inventory.add(item);
			}
			
			inventoryResult.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return inventory;
	}
	
	
	
}

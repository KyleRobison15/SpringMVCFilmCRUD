package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Film;

public class JDBCFilmDAOImpl implements FilmDAO{

	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	private final String user = "student";
	private final String pass = "student";
	
	public JDBCFilmDAOImpl() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
///////////////////////////////////////////////// FILM /////////////////////////////////////////////////

	@Override
	public List<Film> getFilms() {
		
	    List<Film> films = new ArrayList<>();
	    
	    try {
	      Connection conn = DriverManager.getConnection(url, user, pass);
	      
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
	
	
}

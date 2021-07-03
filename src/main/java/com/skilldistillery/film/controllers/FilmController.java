package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private FilmDAO filmDAO;

	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}

	@RequestMapping(path = "ListAllFilms.do", method = RequestMethod.GET)
	public ModelAndView listAllStates() {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.getFilms();
		
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/listFilms.jsp");
		
		return mv;
	}
	
	@RequestMapping(path = "GetFilmById.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(id);
		
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/displayFullFilm.jsp");
		
		return mv;
	}
	
	@RequestMapping(path = "GetFilmsByKeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmsByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmsByKeyword(keyword);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/listFilms.jsp");
		
		return mv;
	}
	
	@RequestMapping(path = "editFilm.do", params = "film", method = RequestMethod.GET)
	public ModelAndView updateFilmInDatabase(@RequestParam("film") Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film films = filmDAO.updateFilmInDatabase(film);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/updateFilm.jsp");
		
		return mv;
	}
	
	@RequestMapping(path = "deleteFilm.do", params = "film", method = RequestMethod.GET)
	public ModelAndView deleteFilmFromDatabase(@RequestParam("film") Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film films = filmDAO.deleteFilmFromDatabase(film);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/listFilms.jsp");
		
		return mv;
	}

}

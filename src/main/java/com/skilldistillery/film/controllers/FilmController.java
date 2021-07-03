package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(path = "listAllFilms.do", method = RequestMethod.GET)
	public ModelAndView listAllStates() {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.getFilms();
		
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/result.jsp");
		
		return mv;
	}

}

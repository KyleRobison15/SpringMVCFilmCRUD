package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		mv.setViewName("listFilms");

		return mv;
	}

	@RequestMapping(path = "GetFilmById.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(id);

		mv.addObject("film", film);
		mv.setViewName("displayFullFilm");

		return mv;
	}

	@RequestMapping(path = "AddFilm.do", method = RequestMethod.POST)
	public ModelAndView addNewFilm(Film film, RedirectAttributes redir) throws SQLException {
		filmDAO.insertFilmToDatabase(film);
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmAdded.do");
		return mv;
	}

	@RequestMapping(path = "filmAdded.do", method = RequestMethod.GET)
	public ModelAndView filmCreated(Film film) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("filmAdded");
		return mv;
	}

	@RequestMapping(path = "GetFilmsByKeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmsByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmsByKeyword(keyword);
		mv.addObject("films", films);
		mv.setViewName("listFilms");

		return mv;
	}

	@RequestMapping(path = "updateFilm.do", params = "id", method = RequestMethod.GET)
	public ModelAndView updateFilmInDatabase(@RequestParam("id") int id) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(id);
		filmDAO.updateFilmInDatabase(film);
		mv.addObject("film", film);
		mv.setViewName("updateFilm");

		return mv;
	}
	
	//Mapping to execute update
	
	@RequestMapping(path = "ConfirmDelete.do", params = "id", method = RequestMethod.GET)
	public ModelAndView confirmDelete(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("deleteFilm");

		return mv;
	}

	@RequestMapping(path = "DeleteFilm.do", params = "id", method = RequestMethod.POST)
	public ModelAndView deleteFilm(int id, RedirectAttributes redir) throws SQLException {
		Film film = filmDAO.findFilmById(id);
		int deleteFlag = filmDAO.deleteFilmFromDatabase(film);
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("deleteFlag", deleteFlag);
		mv.setViewName("redirect:filmDeleted.do");
		return mv;
	}

	@RequestMapping(path = "filmDeleted.do", method = RequestMethod.GET)
	public ModelAndView filmDeleted(Film film) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("filmDeleted");
		return mv;
	}

}

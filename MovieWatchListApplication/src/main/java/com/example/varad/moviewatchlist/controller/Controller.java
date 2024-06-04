package com.example.varad.moviewatchlist.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.varad.moviewatchlist.entity.Movie;
import com.example.varad.moviewatchlist.services.CRUDServices;

import jakarta.validation.Valid;

@RestController
public class Controller {

	@Autowired
	CRUDServices movieService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchlistItemForm(@RequestParam(required = false) Integer id) {
		String viewName = "watchlistItemForm";
		
		Map<String, Object> model = new HashMap<>();
		if(id == null) {
			model.put("movie",new Movie());			
		} else {
			model.put("movie", movieService.getById(id));
		}
		
		return new ModelAndView(viewName, model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView createWatchlistMovie(@Valid Movie movie, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("watchlistItemForm");
		}
		
		movieService.createMovie(movie);
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}

	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		String viewName = "watchlist";
		
		List<Movie> movieList = movieService.getUnwatchedMovies();
		Map<String, Object> model = new HashMap<>();
		model.put("watchlistRows", movieList);
		model.put("noOfMovies", movieList.size());
		return new ModelAndView(viewName, model);
	}
	
	@GetMapping("/watchedmovies")
	public ModelAndView showWatched(@RequestParam(required = false) Integer id) {
		String viewName = "watchedmovies";
		
		List<Movie> movieList = movieService.getWatchedMovies();
		Map<String, Object> model = new HashMap<>();
		if(id != null) {
			Movie mov = movieService.updateWatched(id);
			model.put("updateMovie", mov);
		}
		model.put("movieListRows", movieList);
		model.put("noOfMovies", movieList.size());
		
		return new ModelAndView(viewName, model);
	}
}

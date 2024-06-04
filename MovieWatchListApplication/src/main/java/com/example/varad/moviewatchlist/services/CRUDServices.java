package com.example.varad.moviewatchlist.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.varad.moviewatchlist.entity.Movie;
import com.example.varad.moviewatchlist.repositories.MovieRepository;

@Service
public class CRUDServices {

	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	RatingService ratingService;
	
	List<Movie> watchedList = new LinkedList<>();
	
	public void createMovie(Movie movie) {
		
		String imdbRating = ratingService.getMovieRating(movie.getTitle());
		if(imdbRating != null) {
			movie.setRating(imdbRating);
		}
		movieRepo.save(movie);
	}

	public java.util.List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}

	public Movie getById(Integer id) {
		// TODO Auto-generated method stub
		return movieRepo.findById(id).get();
	}

	public Movie updateWatched(Integer id) {
		// TODO Auto-generated method stub
		Movie mov = movieRepo.findById(id).get();
		mov.setWatched(true);
		watchedList.add(mov);
		movieRepo.save(mov);
		return mov;
	}

	public List<Movie> getWatchedMovies() {
		// TODO Auto-generated method stub
		List<Movie> movieList = watchedList;
		return movieList;
	}
	
	public List<Movie> getUnwatchedMovies() {
		// TODO Auto-generated method stub
		ArrayList<Movie> movieList = (ArrayList<Movie>) getAllMovie();
		for(int i=0; i<movieList.size(); i++) {
			if(movieList.get(i).isWatched() != false) {
				movieList.remove(i);
			}
		}
		return movieList;
	}
}

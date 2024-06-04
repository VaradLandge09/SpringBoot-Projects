package com.example.varad.moviewatchlist.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {

	String apiUrl = "https://www.omdbapi.com/?apikey=22733ed2&t=";
	
	public String getMovieRating(String title) {
		
		try {
			RestTemplate template = new RestTemplate();
			ResponseEntity<ObjectNode> responce = template.getForEntity(apiUrl + title, ObjectNode.class);
			ObjectNode jsonBody = responce.getBody();
			return jsonBody.path("imdbRating").asText();
			
		} catch (Exception e) {
			System.out.println("Either the movie is not present or Api is down");
			return null;
		}
	}
}

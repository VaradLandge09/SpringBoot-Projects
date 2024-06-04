package com.example.varad.moviewatchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.varad.moviewatchlist.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}

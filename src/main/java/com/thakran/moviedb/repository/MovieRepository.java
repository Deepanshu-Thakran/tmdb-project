package com.thakran.moviedb.repository;

import com.thakran.moviedb.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

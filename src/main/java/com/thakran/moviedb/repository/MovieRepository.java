package com.thakran.moviedb.repository;

import com.thakran.moviedb.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT m FROM Movie m ORDER BY m.rating ASC")
    List<Movie> getMoviesByRanking();

}

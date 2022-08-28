package com.thakran.moviedb.service;

import com.thakran.moviedb.dto.request.addMovie.AddMovieRequestDTO;
import com.thakran.moviedb.dto.request.deleteMovie.DeleteMovieRequestDTO;
import com.thakran.moviedb.dto.request.updateMovie.UpdateMovieRequestDTO;
import com.thakran.moviedb.dto.response.addMovie.AddMovieResponseDTO;
import com.thakran.moviedb.dto.response.deleteMovie.DeleteMovieResponseDTO;
import com.thakran.moviedb.dto.response.movieList.MovieListResponseDTO;
import com.thakran.moviedb.dto.response.updateMovie.UpdateMovieResponseDTO;

public interface MovieService {

    MovieListResponseDTO movieList();

    UpdateMovieResponseDTO updateMovie(UpdateMovieRequestDTO updateMovieRequestDTO);

    DeleteMovieResponseDTO deleteMovie(DeleteMovieRequestDTO deleteMovieRequestDTO);

    AddMovieResponseDTO addMovie(AddMovieRequestDTO addMovieRequestDTO);

}

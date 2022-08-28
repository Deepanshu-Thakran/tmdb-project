package com.thakran.moviedb.service;

import com.thakran.moviedb.dto.request.addMovie.AddMovieRequestDTO;
import com.thakran.moviedb.dto.request.deleteMovie.DeleteMovieRequestDTO;
import com.thakran.moviedb.dto.request.updateMovie.UpdateMovieRequestDTO;
import com.thakran.moviedb.dto.response.addMovie.AddMovieResponseDTO;
import com.thakran.moviedb.dto.response.deleteMovie.DeleteMovieResponseDTO;
import com.thakran.moviedb.dto.response.movieList.MovieListResponseDTO;
import com.thakran.moviedb.dto.response.updateMovie.UpdateMovieResponseDTO;
import com.thakran.moviedb.model.Movie;
import com.thakran.moviedb.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieListResponseDTO movieList() {
        MovieListResponseDTO response = new MovieListResponseDTO();
        List<Movie> movieList = movieRepository.findAll();

        if (movieList.isEmpty()) {
            return response.setStatus(204).setMessage("No records found!").setMovieList(null);
        } else {
            return response.setMovieList(movieList).setStatus(200).setMessage("Success!");
        }
    }

    @Override
    public UpdateMovieResponseDTO updateMovie(UpdateMovieRequestDTO requestDTO) {
        Long id = Long.valueOf(requestDTO.getId());
        Float rating = Float.valueOf(requestDTO.getRating());
        Optional<Movie> movieToBeUpdatedOpt = movieRepository.findById(id);

        if (!movieToBeUpdatedOpt.isPresent()) return new UpdateMovieResponseDTO().setStatus(400).setMessage("Movie not found!").setData(null);

        Movie movieToBeUpdated = movieToBeUpdatedOpt.get();

        movieToBeUpdated.setRating(rating).setReview(requestDTO.getReview());

        try{
            Movie updatedMovie = movieRepository.save(movieToBeUpdated);

            return new UpdateMovieResponseDTO().setStatus(200).setMessage("Details updated successfully!").setData(updatedMovie);
        } catch (DataIntegrityViolationException e) {
            return new UpdateMovieResponseDTO().setStatus(500).setMessage(e.getMessage()).setData(null);
        }
    }

    @Override
    public DeleteMovieResponseDTO deleteMovie(DeleteMovieRequestDTO requestDTO) {
        Long id = Long.valueOf(requestDTO.getId());

        Optional<Movie> movieToBeDeletedOpt = movieRepository.findById(id);

        if (!movieToBeDeletedOpt.isPresent()) return new DeleteMovieResponseDTO().setStatus(400).setMessage("Movie not found!");

        Movie movieToBeDeleted = movieToBeDeletedOpt.get();

        try{
            movieRepository.delete(movieToBeDeleted);

            return new DeleteMovieResponseDTO().setStatus(200).setMessage("Movie deleted successfully!");
        } catch (DataIntegrityViolationException e) {
            return new DeleteMovieResponseDTO().setStatus(500).setMessage(e.getMessage());
        }
    }

    @Override
    public AddMovieResponseDTO addMovie(AddMovieRequestDTO requestDTO) {
        Integer year = Integer.valueOf(requestDTO.getYear());
        Float rating = Float.valueOf(requestDTO.getRating());
        Integer ranking = Integer.valueOf(requestDTO.getRanking());

        Movie movieToBeAdded = new Movie().setTitle(requestDTO.getTitle()).setYear(year)
                .setDescription(requestDTO.getDescription()).setRating(rating).setRanking(ranking)
                .setReview(requestDTO.getReview()).setImgUrl(requestDTO.getImgUrl());

        try{
            Movie addedMovie = movieRepository.save(movieToBeAdded);

            return new AddMovieResponseDTO().setStatus(200).setMessage("Added movie successfully!").setData(addedMovie);
        } catch (DataIntegrityViolationException e) {
            return new AddMovieResponseDTO().setStatus(500).setMessage(e.getMessage()).setData(null);
        }
    }
}

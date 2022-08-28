package com.thakran.moviedb.controller;

import com.thakran.moviedb.dto.request.addMovie.AddMovieRequestDTO;
import com.thakran.moviedb.dto.request.deleteMovie.DeleteMovieRequestDTO;
import com.thakran.moviedb.dto.request.updateMovie.UpdateMovieRequestDTO;
import com.thakran.moviedb.dto.response.addMovie.AddMovieResponseDTO;
import com.thakran.moviedb.dto.response.deleteMovie.DeleteMovieResponseDTO;
import com.thakran.moviedb.dto.response.movieList.MovieListResponseDTO;
import com.thakran.moviedb.dto.response.updateMovie.UpdateMovieResponseDTO;
import com.thakran.moviedb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/movie-db")
@CrossOrigin(origins = "*")
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movieList")
    public ResponseEntity<MovieListResponseDTO> movieList() {
        MovieListResponseDTO responseDTO = movieService.movieList();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/updateMovie")
    public ResponseEntity<UpdateMovieResponseDTO> updateMovie(@RequestBody @Valid UpdateMovieRequestDTO updateMovieRequestDTO) {
        UpdateMovieResponseDTO responseDTO = movieService.updateMovie(updateMovieRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMovie")
    public ResponseEntity<DeleteMovieResponseDTO> deleteMovie(@Valid DeleteMovieRequestDTO deleteMovieRequestDTO){
        DeleteMovieResponseDTO responseDTO = movieService.deleteMovie(deleteMovieRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<AddMovieResponseDTO> addMovie(@RequestBody @Valid AddMovieRequestDTO addMovieRequestDTO){
        AddMovieResponseDTO responseDTO = movieService.addMovie(addMovieRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

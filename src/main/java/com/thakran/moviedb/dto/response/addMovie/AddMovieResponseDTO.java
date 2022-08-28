package com.thakran.moviedb.dto.response.addMovie;

import com.thakran.moviedb.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AddMovieResponseDTO implements Serializable {

    private Integer status;

    private String message;

    private Movie data;

}

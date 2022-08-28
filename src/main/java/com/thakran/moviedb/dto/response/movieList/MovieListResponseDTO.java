package com.thakran.moviedb.dto.response.movieList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thakran.moviedb.model.Movie;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
public class MovieListResponseDTO implements Serializable {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("movie_list")
    private List<Movie> movieList;

}

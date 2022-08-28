package com.thakran.moviedb.dto.request.updateMovie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UpdateMovieRequestDTO {

    @JsonProperty("movie_id")
    @NotBlank(message = "Movie Id should not be empty!")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Please pass valid movie_id!")
    private String id;

    @JsonProperty("rating")
    @NotBlank(message = "Rating should not be empty!")
    @Pattern(regexp = "^\\d*\\.?\\d*$", message = "Please pass a valid rating!")
    private String rating;

    @JsonProperty("review")
    @NotBlank(message = "Review should not be empty!")
    private String review;

}

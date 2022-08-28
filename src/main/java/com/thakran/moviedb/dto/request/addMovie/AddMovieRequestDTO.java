package com.thakran.moviedb.dto.request.addMovie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AddMovieRequestDTO implements Serializable {

    @NotBlank(message = "Movie title should not be empty!")
    private String title;

    @NotBlank(message = "Movie year must not be empty!")
    @Pattern(regexp = "^[0-9]*$", message = "Please pass valid year!")
    private String year;

    @NotBlank(message = "Movie description should not be empty!")
    private String description;

    @NotBlank(message = "Movie rating must not be empty!")
    @Pattern(regexp = "^\\d*\\.?\\d*$", message = "Please pass a valid rating!")
    private String rating;

    @NotBlank(message = "Movie ranking must not be empty!")
    @Pattern(regexp = "^[0-9]*$", message = "Please pass valid ranking!")
    private String ranking;

    @NotBlank(message = "Movie review must not be empty!")
    private String review;

    @NotBlank(message = "Movie image path must not be empty!")
    @JsonProperty("img_url")
    private String imgUrl;

}

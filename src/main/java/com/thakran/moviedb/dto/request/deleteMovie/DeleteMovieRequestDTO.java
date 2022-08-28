package com.thakran.moviedb.dto.request.deleteMovie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DeleteMovieRequestDTO {

    @NotBlank(message = "Please pass movie_id!")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Please pass valid movie_id!")
    private String id;

}

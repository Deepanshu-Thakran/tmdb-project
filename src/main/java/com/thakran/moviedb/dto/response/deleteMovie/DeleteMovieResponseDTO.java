package com.thakran.moviedb.dto.response.deleteMovie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DeleteMovieResponseDTO {

    private Integer status;

    private String message;

}

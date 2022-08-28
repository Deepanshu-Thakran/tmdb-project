package com.thakran.moviedb.dto.response.updateMovie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UpdateMovieResponseDTO implements Serializable {

    private Integer status;

    private String message;

    private Object data;

}

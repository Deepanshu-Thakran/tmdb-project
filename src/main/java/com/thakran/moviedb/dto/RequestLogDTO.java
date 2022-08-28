package com.thakran.moviedb.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class RequestLogDTO implements Serializable {

    private String request;

}

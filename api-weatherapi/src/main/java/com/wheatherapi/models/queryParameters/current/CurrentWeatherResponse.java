package com.wheatherapi.models.queryParameters.current;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeatherResponse{

    @JsonProperty("current")
    private Current current;

    @JsonProperty("location")
    private Location location;
}
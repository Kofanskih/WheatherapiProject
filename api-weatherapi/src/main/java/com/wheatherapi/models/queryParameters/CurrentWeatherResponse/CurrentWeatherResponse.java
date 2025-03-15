package com.wheatherapi.models.queryParameters.CurrentWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CurrentWeatherResponse{

    @JsonProperty("current")
    private Current current;

    @JsonProperty("location")
    private Location location;
}
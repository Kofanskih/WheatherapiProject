package com.wheatherapi.models.queryParameters.MarineWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MarineWeatherResponse {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("forecast")
    private Forecast forecast;
}
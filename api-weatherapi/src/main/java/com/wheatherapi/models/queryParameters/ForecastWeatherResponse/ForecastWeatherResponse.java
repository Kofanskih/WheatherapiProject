package com.wheatherapi.models.queryParameters.ForecastWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ForecastWeatherResponse{

    @JsonProperty("alerts")
    private Alerts alerts;

    @JsonProperty("current")
    private Current current;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("forecast")
    private Forecast forecast;
}
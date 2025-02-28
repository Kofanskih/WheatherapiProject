package com.wheatherapi.models.queryParameters.FutureWeatherResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FutureWeatherResponse{

    @JsonProperty
    private Location location;

    @JsonProperty
    private Forecast forecast;
}

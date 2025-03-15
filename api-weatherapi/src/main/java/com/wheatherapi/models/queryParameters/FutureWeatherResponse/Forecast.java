package com.wheatherapi.models.queryParameters.FutureWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class Forecast{
    @JsonProperty ("forecastday")
    private List<ForecastdayItem> forecastday;
}
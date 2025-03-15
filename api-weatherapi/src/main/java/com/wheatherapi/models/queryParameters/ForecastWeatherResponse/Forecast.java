package com.wheatherapi.models.queryParameters.ForecastWeatherResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Forecast{

    @JsonProperty("forecastday")
    private List<ForecastdayItem> forecastday;
}
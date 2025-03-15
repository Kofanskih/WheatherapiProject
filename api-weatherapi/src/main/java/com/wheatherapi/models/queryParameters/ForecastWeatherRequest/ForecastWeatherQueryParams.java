package com.wheatherapi.models.queryParameters.ForecastWeatherRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForecastWeatherQueryParams {
    @JsonProperty("q")
    private String q;

    @JsonProperty("days")
    private int days;

    @JsonProperty("key")
    private String key;
}

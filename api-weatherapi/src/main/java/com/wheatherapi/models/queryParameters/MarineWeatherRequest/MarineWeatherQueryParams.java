package com.wheatherapi.models.queryParameters.MarineWeatherRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MarineWeatherQueryParams {
    @JsonProperty("q")
    private String q;

    @JsonProperty("days")
    private int days;

    @JsonProperty("key")
    private String key;
}

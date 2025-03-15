package com.wheatherapi.models.queryParameters.CurrentWeatherRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentWeatherQueryParams {
    @JsonProperty("q")
    private String q;

    @JsonProperty("key")
    private String key;
}

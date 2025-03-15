package com.wheatherapi.models.queryParameters.ForecastWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Condition{

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("text")
    private String text;
}
package com.wheatherapi.models.queryParameters.ForecastWeatherResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Alerts{

    @JsonProperty("alert")
    private List<AlertItem> alert;
}
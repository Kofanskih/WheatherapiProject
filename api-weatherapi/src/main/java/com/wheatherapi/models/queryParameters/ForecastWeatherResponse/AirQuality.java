package com.wheatherapi.models.queryParameters.ForecastWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AirQuality{

    @JsonProperty("no2")
    private Object no2;

    @JsonProperty("o3")
    private Object o3;

    @JsonProperty("us-epa-index")
    private Integer usEpaIndex;

    @JsonProperty("so2")
    private Integer so2;

    @JsonProperty("pm2_5")
    private Object pm25;

    @JsonProperty("pm10")
    private Integer pm10;

    @JsonProperty("co")
    private Object co;

    @JsonProperty("gb-defra-index")
    private Integer gbDefraIndex;
}
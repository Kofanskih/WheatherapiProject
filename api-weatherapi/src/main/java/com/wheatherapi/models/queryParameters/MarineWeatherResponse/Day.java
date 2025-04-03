package com.wheatherapi.models.queryParameters.MarineWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Day{

    @JsonProperty("avgvis_km")
    private Object avgvisKm;

    @JsonProperty("uv")
    private Object uv;

    @JsonProperty("avgtemp_f")
    private Object avgtempF;

    @JsonProperty("avgtemp_c")
    private Object avgtempC;

    @JsonProperty("maxtemp_c")
    private Object maxtempC;

    @JsonProperty("maxtemp_f")
    private Object maxtempF;

    @JsonProperty("mintemp_c")
    private Object mintempC;

    @JsonProperty("avgvis_miles")
    private Object avgvisMiles;

    @JsonProperty("mintemp_f")
    private Object mintempF;

    @JsonProperty("totalprecip_in")
    private Object totalprecipIn;

    @JsonProperty("totalsnow_cm")
    private Object totalsnowCm;

    @JsonProperty("avghumidity")
    private Object avghumidity;

    @JsonProperty("condition")
    private Condition condition;

    @JsonProperty("maxwind_kph")
    private Object maxwindKph;

    @JsonProperty("maxwind_mph")
    private Object maxwindMph;

    @JsonProperty("totalprecip_mm")
    private Object totalprecipMm;
}
package com.wheatherapi.models.queryParameters.ForecastWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Day{

    @JsonProperty("avgvis_km")
    private Integer avgvisKm;

    @JsonProperty("uv")
    private Integer uv;

    @JsonProperty("avgtemp_f")
    private Object avgtempF;

    @JsonProperty("avgtemp_c")
    private Object avgtempC;

    @JsonProperty("daily_chance_of_snow")
    private Integer dailyChanceOfSnow;

    @JsonProperty("maxtemp_c")
    private Object maxtempC;

    @JsonProperty("maxtemp_f")
    private Object maxtempF;

    @JsonProperty("mintemp_c")
    private Object mintempC;

    @JsonProperty("avgvis_miles")
    private Integer avgvisMiles;

    @JsonProperty("daily_will_it_rain")
    private Integer dailyWillItRain;

    @JsonProperty("mintemp_f")
    private Object mintempF;

    @JsonProperty("totalprecip_in")
    private Integer totalprecipIn;

    @JsonProperty("avghumidity")
    private Integer avghumidity;

    @JsonProperty("condition")
    private Condition condition;

    @JsonProperty("maxwind_kph")
    private Object maxwindKph;

    @JsonProperty("maxwind_mph")
    private Object maxwindMph;

    @JsonProperty("daily_chance_of_rain")
    private Integer dailyChanceOfRain;

    @JsonProperty("totalprecip_mm")
    private Integer totalprecipMm;

    @JsonProperty("daily_will_it_snow")
    private Integer dailyWillItSnow;

    @JsonProperty("totalsnow_cm")
    private Object totalsnowCm;

}
package com.wheatherapi.models.queryParameters.CurrentWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Current{

    @JsonProperty("feelslike_c")
    private Object feelslikeC;

    @JsonProperty("feelslike_f")
    private Object feelslikeF;

    @JsonProperty("wind_degree")
    private Integer windDegree;

    @JsonProperty("windchill_f")
    private Object windchillF;

    @JsonProperty("windchill_c")
    private Object windchillC;

    @JsonProperty("last_updated_epoch")
    private Integer lastUpdatedEpoch;

    @JsonProperty("temp_c")
    private Object tempC;

    @JsonProperty("temp_f")
    private Object tempF;

    @JsonProperty("cloud")
    private Integer cloud;

    @JsonProperty("wind_kph")
    private Object windKph;

    @JsonProperty("wind_mph")
    private Object windMph;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("dewpoint_f")
    private Object dewpointF;

    @JsonProperty("uv")
    private Object uv;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("heatindex_f")
    private Object heatindexF;

    @JsonProperty("dewpoint_c")
    private Object dewpointC;

    @JsonProperty("is_day")
    private Integer isDay;

    @JsonProperty("precip_in")
    private Object precipIn;

    @JsonProperty("heatindex_c")
    private Object heatindexC;

    @JsonProperty("wind_dir")
    private String windDir;

    @JsonProperty("gust_mph")
    private Object gustMph;

    @JsonProperty("pressure_in")
    private Object pressureIn;

    @JsonProperty("gust_kph")
    private Object gustKph;

    @JsonProperty("precip_mm")
    private Object precipMm;

    @JsonProperty("condition")
    private Condition condition;

    @JsonProperty("vis_km")
    private Object visKm;

    @JsonProperty("pressure_mb")
    private Object pressureMb;

    @JsonProperty("vis_miles")
    private Object visMiles;
}
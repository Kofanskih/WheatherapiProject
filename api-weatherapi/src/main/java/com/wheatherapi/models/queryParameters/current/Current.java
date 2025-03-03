package com.wheatherapi.models.queryParameters.current;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Current{

    @JsonProperty("feelslike_c")
    private Integer feelslikeC;

    @JsonProperty("uv")
    private Integer uv;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("feelslike_f")
    private Object feelslikeF;

    @JsonProperty("wind_degree")
    private Integer windDegree;

    @JsonProperty("last_updated_epoch")
    private Integer lastUpdatedEpoch;

    @JsonProperty("is_day")
    private Integer isDay;

    @JsonProperty("precip_in")
    private Integer precipIn;

    @JsonProperty("air_quality")
    private AirQuality airQuality;

    @JsonProperty("wind_dir")
    private String windDir;

    @JsonProperty("gust_mph")
    private Object gustMph;

    @JsonProperty("temp_c")
    private Object tempC;

    @JsonProperty("pressure_in")
    private Object pressureIn;

    @JsonProperty("gust_kph")
    private Object gustKph;

    @JsonProperty("temp_f")
    private Object tempF;

    @JsonProperty("precip_mm")
    private Integer precipMm;

    @JsonProperty("cloud")
    private Integer cloud;

    @JsonProperty("wind_kph")
    private Object windKph;

    @JsonProperty("condition")
    private Condition condition;

    @JsonProperty("wind_mph")
    private Object windMph;

    @JsonProperty("vis_km")
    private Integer visKm;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("pressure_mb")
    private Integer pressureMb;

    @JsonProperty("vis_miles")
    private Integer visMiles;
}
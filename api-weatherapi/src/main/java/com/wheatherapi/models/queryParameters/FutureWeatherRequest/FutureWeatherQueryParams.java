package com.wheatherapi.models.queryParameters.FutureWeatherRequest;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class FutureWeatherQueryParams {
    @JsonProperty("q")
    private String q;

    @JsonProperty("key")
    private String key;

    @JsonProperty("dt")
    private String dt;


    @JsonIgnore
    @JsonProperty("location")
    private String location;

    @JsonIgnore
    @JsonProperty("forecast")
    private String forecast;



}

package com.wheatherapi.models.queryParameters.FutureWeatherResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Location{
    @JsonProperty
    private String localtime;

    @JsonProperty
    private String country;

    @JsonProperty ("localtime_epoch")
    private Integer localtimeEpoch;

    @JsonProperty
    private String name;

    @JsonProperty
    private Object lon;

    @JsonProperty
    private String region;

    @JsonProperty
    private Object lat;

    @JsonProperty ("tz_id")
    private String tzId;
}

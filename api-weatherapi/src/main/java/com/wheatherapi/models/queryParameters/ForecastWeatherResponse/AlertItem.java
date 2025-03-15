package com.wheatherapi.models.queryParameters.ForecastWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AlertItem{

    @JsonProperty("severity")
    private Object severity;

    @JsonProperty("note")
    private Object note;

    @JsonProperty("expires")
    private String expires;

    @JsonProperty("certainty")
    private Object certainty;

    @JsonProperty("areas")
    private Object areas;

    @JsonProperty("effective")
    private String effective;

    @JsonProperty("urgency")
    private Object urgency;

    @JsonProperty("instruction")
    private String instruction;

    @JsonProperty("category")
    private String category;

    @JsonProperty("event")
    private String event;

    @JsonProperty("headline")
    private String headline;

    @JsonProperty("msgtype")
    private Object msgtype;

    @JsonProperty("desc")
    private String desc;
}
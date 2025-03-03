package com.wheatherapi.models.queryParameters.current;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Condition{

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("text")
    private String text;
}
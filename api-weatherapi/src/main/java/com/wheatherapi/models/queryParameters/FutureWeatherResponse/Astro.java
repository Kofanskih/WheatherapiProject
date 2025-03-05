package com.wheatherapi.models.queryParameters.FutureWeatherResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Astro{
    @JsonProperty ("moonset")
    private String moonset;

    @JsonProperty ("moon_illumination")
    private String moonIllumination;

    @JsonProperty ("sunrise")
    private String sunrise;

    @JsonProperty ("moon_phase")
    private String moonPhase;

    @JsonProperty ("sunset")
    private String sunset;

    @JsonProperty ("moonrise")
    private String moonrise;
}

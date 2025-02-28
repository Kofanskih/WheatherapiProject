package com.wheatherapi.models.queryParameters.FutureWeatherResponse;

import java.util.List;

public class ForecastdayItem{
    private String date;
    private Astro astro;
    private Integer dateEpoch;
    private List<HourItem> hour;
    private Day day;
}
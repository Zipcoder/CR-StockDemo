package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;


@JsonIgnoreProperties(ignoreUnknown = true)
public class StockResponse {

    @JsonProperty("Meta Data")
    private MetaData metaData;


    @JsonProperty("Monthly Time Series")
    private HashMap<String, MonthlyTimeSeries> monthlyTimeSeries;

    public HashMap<String, MonthlyTimeSeries> getMonthlyTimeSeries() {
        return monthlyTimeSeries;
    }

    public void setMonthlyTimeSeries(HashMap<String, MonthlyTimeSeries> monthlyTimeSeries) {
        this.monthlyTimeSeries = monthlyTimeSeries;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "StockResponse{" +
                "mettadata='" + metaData.getInformation()  + '\'' +
                ", time=" + monthlyTimeSeries.toString() +
                '}';
    }
}


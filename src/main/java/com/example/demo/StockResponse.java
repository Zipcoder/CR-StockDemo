package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;


@JsonIgnoreProperties(ignoreUnknown = true)
public class StockResponse {

    private static final Logger log = LoggerFactory.getLogger(StockResponse.class);

    @JsonProperty(value = "Meta Data", required = false)
    private MetaData metaData;


    @JsonProperty(value = "Monthly Time Series", required = false)
    private HashMap<String, MonthlyTimeSeriesEntry> monthlyTimeSeries;


    public StockResponse(){
        log.info("Creating StockResponse instance");
    }

    public HashMap<String, MonthlyTimeSeriesEntry> getMonthlyTimeSeries() {
        return monthlyTimeSeries;
    }

    public void setMonthlyTimeSeries(HashMap<String, MonthlyTimeSeriesEntry> monthlyTimeSeries) {
        this.monthlyTimeSeries = monthlyTimeSeries;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        log.info("Metadata set to:\n" + metaData);

        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "StockResponse{" +
                "metadata='" + metaData  + '\'' +
                ", time=" + monthlyTimeSeries.toString() +
                '}';
    }
}


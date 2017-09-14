package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthlyTimeSeriesEntry {

    private static final Logger log = LoggerFactory.getLogger(MonthlyTimeSeriesEntry.class);

    @JsonProperty("1. open")
    private String open;
    @JsonProperty("2. high")
    private String high;

    @JsonProperty("3. low")
    private String low;

    @JsonProperty("4. close")
    private String close;

    @JsonProperty("5. volume")
    private String volume;

    public MonthlyTimeSeriesEntry(){
        log.trace("MonthlyTimeSeriesEntry Instance created");
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        log.trace("Setting open to: " + open);
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        log.trace("Setting high to: " + high);
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        log.trace("Setting low to: " + low);
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        log.trace("Setting close to: " + close);
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        log.trace("Setting volume to: " + volume);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("High:\t%s\nLow\t%s\nOpen:\t%s\nClose:\t%s\nVolume:\t%s\n", high, low, open, close, volume);
    }
}

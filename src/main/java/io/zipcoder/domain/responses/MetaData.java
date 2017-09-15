package io.zipcoder.domain.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData {

    @JsonProperty("1. Information")
    private String information;

    @JsonProperty("2. Symbol")
    private String symbol;

    @JsonProperty("3. Last Refreshed")
    private String lastRefreshed;

    @JsonProperty("4. Time Zone")
    private String timeZone;

    public String getInformation() {
        return information;
    }

    public MetaData setInformation(String information) {
        this.information = information;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public MetaData setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public MetaData setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
        return this;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public MetaData setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }
}

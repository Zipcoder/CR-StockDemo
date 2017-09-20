package io.zipcoder.domain.responses;

import io.zipcoder.domain.temporalresolution.TemporalResolutionIntraday;

import javax.persistence.Entity;

/**
 * Created by leon on 9/15/17.
 */
@Entity
public class StockResponseIntraday extends StockResponse<TemporalResolutionIntraday> {
}

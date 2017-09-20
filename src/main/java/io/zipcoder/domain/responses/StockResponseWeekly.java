package io.zipcoder.domain.responses;

import io.zipcoder.domain.temporalresolution.TemporalResolutionWeekly;

import javax.persistence.Entity;

/**
 * Created by leon on 9/15/17.
 */
@Entity
public class StockResponseWeekly extends StockResponse<TemporalResolutionWeekly> {
}

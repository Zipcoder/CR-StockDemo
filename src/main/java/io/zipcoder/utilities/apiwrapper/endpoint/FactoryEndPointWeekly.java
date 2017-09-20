package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponseWeekly;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;

/**
 * Created by leon on 9/15/17.
 */
public final class FactoryEndPointWeekly extends FactoryEndPointTemporal<StockResponseWeekly> {
    public FactoryEndPointWeekly(String apiKey) {
        super(apiKey, ParamFunction.WEEKLY);
    }
}
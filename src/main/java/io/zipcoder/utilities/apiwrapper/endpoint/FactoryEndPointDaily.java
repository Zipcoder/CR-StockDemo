package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponseDaily;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;

/**
 * Created by leon on 9/15/17.
 * DailyEndPoint factory
 */
public class FactoryEndPointDaily extends FactoryEndPointTemporal<StockResponseDaily> {
    public FactoryEndPointDaily(String apiKey) {
        super(apiKey, ParamFunction.DAILY);
    }
}

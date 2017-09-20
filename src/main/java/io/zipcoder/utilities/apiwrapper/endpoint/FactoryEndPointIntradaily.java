package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponseIntraday;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;
import io.zipcoder.utilities.apiwrapper.parameters.ParamInterval;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;

/**
 * Created by leon on 9/15/17.
 */
public class FactoryEndPointIntradaily extends FactoryEndPointTemporal<StockResponseIntraday> {
    public FactoryEndPointIntradaily(String apiKey) {
        super(apiKey, ParamFunction.INTRADAY);
    }

    public EndPoint<StockResponseIntraday> getFullOutput(ParamInterval interval, ParamSymbol symbol) {
        return super.get(interval, symbol, ParamOutputSize.FULL);
    }

    public EndPoint<StockResponseIntraday> getCompactOutput(ParamInterval interval, ParamSymbol symbol) {
        return super.get(interval, symbol, ParamOutputSize.COMPACT);
    }
}

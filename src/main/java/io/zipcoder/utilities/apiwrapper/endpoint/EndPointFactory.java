package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponse;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;
import io.zipcoder.utilities.apiwrapper.parameters.ParamInterval;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;

/**
 * Created by leon on 9/14/17.
 */
public final class EndPointFactory<T extends StockResponse> {

    private final String apiKey;

    public EndPointFactory(String apiKey) {
        this.apiKey = apiKey;
    }

    public EndPoint<T> get(ParamFunction function, ParamInterval interval, ParamSymbol symbol, ParamOutputSize outputSize) {
        return new EndPoint<>(function, interval, symbol, outputSize, apiKey);
    }


    public EndPoint get(ParamFunction function, ParamInterval interval, ParamSymbol symbol) {
        return get(function, interval, symbol, ParamOutputSize.FULL);
    }

    public EndPoint get(String function, String interval, String symbol, String outputSize) {
        return get(
                ParamFunction.valueOf(function),
                ParamInterval.valueOf(interval),
                ParamSymbol.valueOf(symbol),
                ParamOutputSize.valueOf(outputSize));
    }

    public EndPoint get(String function, String interval, String symbol) {
        return get(function, interval, symbol, ParamOutputSize.FULL.toString());
    }

}

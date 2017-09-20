package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponse;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;
import io.zipcoder.utilities.apiwrapper.parameters.ParamInterval;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;

import java.util.logging.Logger;

/**
 * Created by leon on 9/14/17.
 * EndPoint factory
 */
public final class FactoryEndPoint<T extends StockResponse> {
    private final Logger log = Logger.getLogger(getClass().getSimpleName());
    private final String apiKey;

    public FactoryEndPoint(String apiKey) {
        this.apiKey = apiKey;
    }

    public EndPoint<T> get(ParamFunction function, ParamInterval interval, ParamSymbol symbol, ParamOutputSize outputSize) {
        EndPoint endPoint = new EndPoint<>(function, interval, symbol, outputSize, apiKey);
        log.info("Successfully created new endpoint.");
        log.info("EndPoint URI = " + endPoint.toString());
        return endPoint;
    }


    public EndPoint<T> get(ParamFunction function, ParamSymbol symbol, ParamOutputSize outputSize) {
        return get(function, null, symbol, outputSize);
    }


    public EndPoint get(String function, String interval, String symbol, String outputSize) {
        return get(
                ParamFunction.valueOf(function),
                ParamInterval.getValueOf(interval),
                ParamSymbol.valueOf(symbol),
                ParamOutputSize.valueOf(outputSize));
    }

    public EndPoint get(String function, String symbol, String outputSize) {
        return get(function, null, symbol, outputSize);
    }

}

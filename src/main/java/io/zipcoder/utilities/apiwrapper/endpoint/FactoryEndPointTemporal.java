package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponse;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;
import io.zipcoder.utilities.apiwrapper.parameters.ParamInterval;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;

/**
 * Created by leon on 9/15/17.
 */
public abstract class FactoryEndPointTemporal<T extends StockResponse> {
    protected final FactoryEndPoint<T> factory;
    private final ParamFunction paramFunction;

    public FactoryEndPointTemporal(String apiKey, ParamFunction paramFunction) {
        this.factory = new FactoryEndPoint(apiKey);
        this.paramFunction = paramFunction;
    }

    protected EndPoint<T> get(ParamInterval interval, ParamSymbol symbol, ParamOutputSize outputSize) {
        return factory.get(paramFunction, interval, symbol, outputSize);
    }

    public EndPoint<T> getFullOutput(ParamSymbol symbol) {
        return get(null, symbol, ParamOutputSize.FULL);
    }

    public EndPoint<T> getCompactOutput(ParamSymbol symbol) {
        return get(null, symbol, ParamOutputSize.COMPACT);
    }
}
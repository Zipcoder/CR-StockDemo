package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponse;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;
import io.zipcoder.utilities.apiwrapper.parameters.ParamInterval;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;
import org.springframework.web.client.RestTemplate;

/**
 * Created by leon on 9/14/17.
 */
public class EndPoint<T extends StockResponse> {
    private final String apiCall;

    EndPoint(ParamFunction function, ParamInterval interval, ParamSymbol symbol, ParamOutputSize outputSize, String apiKey) {
        this.apiCall = "https://www.alphavantage.co/query?function="
                + function.toString() + "&symbol="
                + symbol.toString() + "&interval="
                + interval.toString() + "&outputsize="
                + outputSize.toString() + "&apikey="
                + apiKey;
    }

    public T call(Class<T> cls) {
        /** @param cls - Some class of type T
         *  @param <T> - Some sub-type StockResponse
         *  @return respective StockResponse object */
        return new RestTemplate().getForObject(apiCall, cls);
    }

    @Override
    public String toString() {
        return apiCall;
    }
}
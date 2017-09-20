package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.StockResponse;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;
import io.zipcoder.utilities.apiwrapper.parameters.ParamInterval;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

/**
 * Created by leon on 9/14/17.
 */
public class EndPoint<T extends StockResponse> {
    private final String apiCall;

    EndPoint(ParamFunction function, ParamInterval interval, ParamSymbol symbol, ParamOutputSize outputSize, String apiKey) {
        this.apiCall = MessageFormat.format("https://www.alphavantage.co/query?{0}{1}{2}{3}&apikey={4}",
                function.toString(),
                symbol.toString(),
                interval == null ? "" : interval.toString(),
                outputSize.toString(),
                apiKey);
    }

    public T call(Class<T> cls) {
        return call(new RestTemplate(), cls);
    }

    public T call(RestTemplate restTemplate, Class<T> cls) {
        /** @param cls - Some class of parameterized type T
         *  @param <T> - Some sub-type of StockResponse
         *  @param restTemplate - the rest template to get respective object
         *  @return respective StockResponse object */
        return restTemplate.getForObject(apiCall, cls);
    }

    @Override
    public String toString() {
        return apiCall;
    }
}
package io.zipcoder.utilities.apiwrapper.endpoint;

import io.zipcoder.domain.responses.IntraDailyResponse;
import io.zipcoder.utilities.apiwrapper.parameters.ParamFunction;

/**
 * Created by leon on 9/15/17.
 */
public class IntraDailyEndPointFactory extends TemporalEndPointFactory<IntraDailyResponse> {
    public IntraDailyEndPointFactory(String apiKey) {
        super(apiKey, ParamFunction.INTRADAY);
    }
}

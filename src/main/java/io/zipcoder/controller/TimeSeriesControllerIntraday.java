package io.zipcoder.controller;

import io.zipcoder.domain.responses.StockResponseIntraday;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leon on 9/19/17.
 */
@RestController
@RequestMapping(value = "/timeseries/intraday")
public class TimeSeriesControllerIntraday extends TimeSeriesController<StockResponseIntraday> {
    @Override
    protected ResponseEntity<StockResponseIntraday> get(ParamSymbol symbol, ParamOutputSize outputSize) {
        return super.get(new StockResponseIntraday(), symbol, outputSize);
    }
}

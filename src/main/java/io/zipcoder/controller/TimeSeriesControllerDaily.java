package io.zipcoder.controller;

import io.zipcoder.domain.responses.StockResponseDaily;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leon on 9/14/17.
 */
@RestController
@RequestMapping(value = "/daily")
public class TimeSeriesControllerDaily extends TimeSeriesController<StockResponseDaily> {
    @Override
    protected ResponseEntity<StockResponseDaily> get(ParamSymbol symbol, ParamOutputSize outputSize) {
        return super.get(new StockResponseDaily(), symbol, outputSize);
    }
}
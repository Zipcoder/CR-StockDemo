package io.zipcoder.controller;

import io.zipcoder.domain.responses.StockResponse;
import io.zipcoder.utilities.apiwrapper.parameters.ParamOutputSize;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leon on 9/19/17.
 */
@RestController
@RequestMapping(value = "/timeseries")
public abstract class TimeSeriesController<T extends StockResponse> {
    @GetMapping(value = "/get/{symbol}/{outputSize}")
    protected abstract ResponseEntity<T> get(
            @PathVariable ParamSymbol symbol,
            @PathVariable ParamOutputSize outputSize);

    protected ResponseEntity<T> get(T t,
            @PathVariable ParamSymbol symbol,
            @PathVariable ParamOutputSize outputSize) {

        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @GetMapping(value = "/getFull/{symbol}/")
    public ResponseEntity<?> getFull(@PathVariable ParamSymbol symbol) {
        return get(symbol, ParamOutputSize.FULL);
    }


    @GetMapping(value = "/getCompact/{symbol}/")
    public ResponseEntity<?> getCompact(@PathVariable ParamSymbol symbol) {
        return get(symbol, ParamOutputSize.COMPACT);
    }
}

package io.zipcoder;

import io.zipcoder.domain.responses.StockResponseDaily;
import io.zipcoder.domain.responses.MetaData;
import io.zipcoder.domain.temporalresolution.TemporalResolutionDaily;
import io.zipcoder.utilities.apiwrapper.endpoint.FactoryEndPointDaily;
import io.zipcoder.utilities.apiwrapper.endpoint.EndPoint;
import io.zipcoder.utilities.apiwrapper.parameters.ParamInterval;
import io.zipcoder.utilities.apiwrapper.parameters.ParamSymbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.HashMap;

@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

	@Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
	    return args -> {
	        // https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=demo
            FactoryEndPointDaily factory = new FactoryEndPointDaily("demo");
            EndPoint<StockResponseDaily> endPoint = factory.getFullOutput(ParamSymbol.MSFT);
            StockResponseDaily response = endPoint.call(restTemplate, StockResponseDaily.class);
            MetaData metaData = response.getMetaData();
            HashMap<Date, TemporalResolutionDaily> timeSeries = response.getTemporalResolutionData();
            log.info(metaData.toString());
            log.info(timeSeries.toString());
        };
    }
}

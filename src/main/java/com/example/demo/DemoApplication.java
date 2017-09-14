package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {


	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Value( "${co.alphavantage.api.key}" ) private String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		log.info("Generating RestTemplate from builder");
		RestTemplate rt =  builder.build();
		return rt;
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {


		return args -> {

			if(apiKey.equals("demo")){
				log.error("API Key is 'demo'. Configure your API key in resources/application-local.properties");
			}
			// API URI
//	        String targetUrl = String.format("http://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=IBM&apikey=%s", apiKey);
			// Tutorial URI
//	        String targetUrl = "http://gturnquist-quoters.cfapps.io/api/random";

			// Local/demo URI
			String targetUrl = String.format("http://localhost:8080/demodata.json?function=TIME_SERIES_MONTHLY&symbol=IBM&apikey=%s",
					apiKey);
			log.info("Querying from: " + targetUrl);
			StockResponse stockResponse = restTemplate.getForObject(targetUrl, StockResponse.class);
			if(null == stockResponse) {
				log.warn("StockResponse from RestTemplate is null");
			}else {
				log.info(stockResponse.toString());
			}
		};
	}
}

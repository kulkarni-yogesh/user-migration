package com.covisint.datamigration.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.covisint.datamigration.rest.client.ApiClient;
import com.covisint.datamigration.rest.client.RestTemplateApiClient;

@Configuration
public class WebConfig {

	/*
	 * @Bean public ApiClient client() { return new RestTemplateApiClient(); }
	 */
	
	
	  @Bean public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
	  return builder.build(); }
	 
}

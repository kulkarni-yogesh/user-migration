package com.covisint.datamigration.rest.client;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class RestTemplateApiClient implements ApiClient{
	
	@Autowired
	private RestTemplate restTemplate; 
	
	public RestTemplateApiClient() {
		
	}

	
	@SuppressWarnings("unchecked")
	public ResponseEntity<String> getOperation(String uri, Map<String, String> headers) {

		HttpHeaders requestHeaders = initializeHeaders(headers);
		
		@SuppressWarnings("rawtypes")
		HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);

		ResponseEntity<String> respEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		return respEntity;
	}

	public ResponseEntity<String> postOperation(String uri, String request, Map<String, String> headers, Map<String, String> params) {

		HttpHeaders requestHeaders = initializeHeaders(headers);
		
		@SuppressWarnings("rawtypes")
		HttpEntity<?> requestEntity = new HttpEntity(request, requestHeaders);
		
		ResponseEntity<String> respEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
		return respEntity;
	}
		
	public ResponseEntity<String> putOperation(String uri, String request, Map<String, String> headers, Map<String, String> params) {

		HttpHeaders requestHeaders = initializeHeaders(headers);
		
		@SuppressWarnings("rawtypes")
		HttpEntity<?> requestEntity = new HttpEntity(request, requestHeaders);

		ResponseEntity<String> respEntity = restTemplate.exchange(uri, HttpMethod.PUT, requestEntity, String.class);
		return respEntity;
	}
	
	public ResponseEntity<String> postForm(String uri, Map<String, String> headers, MultiValueMap<String, String> params) {
		
		HttpHeaders requestHeaders = initializeHeaders(headers);
		
		@SuppressWarnings("rawtypes")
		HttpEntity<?> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, requestHeaders);
		
        ResponseEntity<String> respEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,  String.class);
		return respEntity;
	}

	private HttpHeaders initializeHeaders(Map<String, String> headers) {
		HttpHeaders requestHeaders = new HttpHeaders();

		headers.forEach((k, v) -> {
			requestHeaders.set(k, v);
		});

		return requestHeaders;
	}
	
	public String getToken(String uri, String clientId, String clientSecret) throws Exception {
		ResponseEntity<String> response = null;

		String token = null;
		
		try {
			Map<String, String> headers = new HashMap<String, String>();
			String auth = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());
			headers.put("Authorization", "Basic " + auth);
			headers.put("Accept", "application/json");

			MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
			parameters.add("grant_type", "client_credentials");

			response = postForm(uri, headers, parameters);

			if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				throw new Exception("Invalid Client Credentials.");
			}
			
			JsonObject jsonObject = new JsonParser().parse(response.getBody()).getAsJsonObject();
			token = jsonObject.get("access_token").getAsString();
		} catch (HttpClientErrorException e) {
			//LOGGER.debug(response.getBody());
			throw new Exception("Expected request not found...");
		} catch (Exception e) {
			//LOGGER.debug(response.getBody());
			throw new Exception("Something went wrong.");
		}
		return token;
	}
}

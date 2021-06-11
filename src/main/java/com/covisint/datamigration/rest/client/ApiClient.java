package com.covisint.datamigration.rest.client;

import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface ApiClient {
	ResponseEntity<String> postOperation(String uri, String request, Map<String, String> headers, Map<String, String> params);
	ResponseEntity<String> getOperation(String uri, Map<String, String> headers);
	ResponseEntity<String> putOperation(String uri, String request, Map<String, String> headers, Map<String, String> params);
	String getToken(String uri, String clientId, String clientSecret) throws Exception;
}

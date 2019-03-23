package com.fop.batch.wrapper.faire.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Utility class in order to contains the methods to interact with the restfull
 * ws.
 * 
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
@Configuration
public abstract class RestUtils {

	@Autowired
	protected Environment env;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}	
	/**
	 * Specific Method to prepare the Http headers to be used by the service wrapper classes.
	 * @return
	 */
	public HttpHeaders getPostHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		List<HttpMethod>methods = new ArrayList<HttpMethod>();
		methods.add(HttpMethod.PUT);
		methods.add(HttpMethod.DELETE);
		methods.add(HttpMethod.POST);
		methods.add(HttpMethod.PATCH);
		methods.add(HttpMethod.GET);
		
		headers.setAccessControlAllowMethods(methods);

		headers.add(env.getProperty("faire.api.token.name"), env.getProperty("faire.api.token.value"));
		headers.add(env.getProperty("faire.api.user.agent"), env.getProperty("faire.api.user.agent.value"));
		headers.add("Allow", "*");
		headers.add("X-HTTP-Method-Override", "PUT");
		headers.add("Access-Control-Request-Method", "*");

		return headers;
	}

	/**
	 * Specific Method to prepare the Http headers to be used by the service wrapper classes.
	 * @return
	 */
	public HttpHeaders getPatchHeaders() {

		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application", "merge-patch+json");
		headers.setContentType(mediaType);
		headers.add(env.getProperty("faire.api.token.name"), env.getProperty("faire.api.token.value"));
		headers.add(env.getProperty("faire.api.user.agent"), env.getProperty("faire.api.user.agent.value"));

		return headers;
	}

	/**
	 * Method to compose the url of the api.
	 * @param api
	 * @return
	 */
	public String getFaireApiDomain(String api) {

		return env.getProperty("faire.api.baseurl") + env.getProperty("faire.api.version") + env.getProperty(api);
	}
	
	public String getFaireApiDomain(String api, String id) {

		return getFaireApiDomain(api).replaceAll("<id>", id);
	}
}

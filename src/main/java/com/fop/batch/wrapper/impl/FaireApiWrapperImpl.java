package com.fop.batch.wrapper.impl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fop.batch.model.Product;
import com.fop.batch.model.ProductOption;
import com.fop.batch.model.ProductOptionRequest;
import com.fop.batch.model.ProductRequest;
import com.fop.batch.wrapper.IFaireApiWrapper;

/**
 * @see com.fop.batch.wrapper.IFaireWrapper
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
@Service
public class FaireApiWrapperImpl implements IFaireApiWrapper {

	private static final Logger logger = LoggerFactory.getLogger(FaireApiWrapperImpl.class);

	private static final String BRAND_ID = "b_d2481b88";
	private static final String PRODUCT_NAME = "Tea Drops";

	@Autowired
	private Environment env;

	@Override
	public List<Product> getAllProducts() {

		List<Product> productList = null;

		HttpEntity<String> entity = new HttpEntity<String>(getHeaders());

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<ProductRequest> response = restTemplate.exchange(
				getUrl(env.getProperty("faire.api.getallproducts")), HttpMethod.GET, entity, ProductRequest.class);

		if (response != null && response.getBody() != null) {

			productList = response.getBody().getProducts();

			Predicate<Product> productPredicate = p -> (!p.getBrandId().equals(BRAND_ID)
					|| p.getName().indexOf(PRODUCT_NAME) == -1);
			productList.removeIf(productPredicate); // allow only specific brand id and product name.
		}

		return productList;
	}

	// TODO Not working
	@Override
	public ProductOption updateProductOption(String optionId,Integer availableQuantity) {

		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application", "merge-patch+json");
		headers.setContentType(mediaType);
		headers.add(env.getProperty("faire.api.token.name"), env.getProperty("faire.api.token.value"));
		headers.add(env.getProperty("faire.api.user.agent"), env.getProperty("faire.api.user.agent.value"));
		
		
		ProductOptionRequest preq = new ProductOptionRequest(availableQuantity);
		
		HttpEntity<ProductOptionRequest> entity = new HttpEntity<ProductOptionRequest>(preq,headers);

		//HttpEntity<ProductOption> entity = new HttpEntity<>(ProductOption, headers);
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		
	

		restTemplate.setRequestFactory(requestFactory);
		ResponseEntity<ProductOption> response = restTemplate.exchange(
				getUrl(env.getProperty("faire.api.updateproductoptions"))+optionId, HttpMethod.PATCH, entity, ProductOption.class);

		return response.getBody();
	}
	
	
	public HttpHeaders getHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.add(env.getProperty("faire.api.token.name"), env.getProperty("faire.api.token.value"));
		headers.add(env.getProperty("faire.api.user.agent"), env.getProperty("faire.api.user.agent.value"));
		return headers;
	}

	public String getUrl(String api) {

		return env.getProperty("faire.api.baseurl") + env.getProperty("faire.api.version") + api;
	}
}

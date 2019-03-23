package com.fop.batch.wrapper.faire.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fop.batch.model.ProductOption;
import com.fop.batch.model.ProductOptionRequest;
import com.fop.batch.wrapper.faire.IProductOptionWrapper;

/**
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 * TODO Make a refactor to inject the RestTemplate (Autowired)
 */
@Service
public class ProductOptionWrapperImpl  extends RestUtils implements IProductOptionWrapper{

	// TODO Method Not working.
	@Override
	public ProductOption update(String optionId,Integer availableQuantity) {
		
		ProductOptionRequest po = new ProductOptionRequest(availableQuantity);
		
		HttpEntity<ProductOptionRequest> entity = new HttpEntity<ProductOptionRequest>(po,super.getPatchHeaders());

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		restTemplate.setRequestFactory(requestFactory);
		ResponseEntity<ProductOption> response = restTemplate.exchange(
				super.getFaireApiDomain("faire.api.productoption.update")+optionId, HttpMethod.PATCH, entity, ProductOption.class);

		return response.getBody();
	}
	
}

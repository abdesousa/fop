package com.fop.batch.wrapper.faire.impl;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fop.batch.model.Product;
import com.fop.batch.model.ProductRequest;
import com.fop.batch.wrapper.faire.IProductWrapper;

/**
 * @see com.fop.batch.wrapper.IFaireWrapper
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 * TODO Make a refactor to inject the RestTemplate (Autowired)
 * TODO Possibility to replace POJO by Optional class.
 */
@Service
public class ProductWrapperImpl extends RestUtils implements IProductWrapper {

	// Constants used at the class.
	public static final String BRAND_ID = "b_d2481b88";
	public static final String PRODUCT_NAME = "Tea Drops";

	@Override
	public List<Product> list() {

		List<Product> lst = null;
		HttpEntity<String> entity = new HttpEntity<String>(super.getPostHeaders());


		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<ProductRequest> response = restTemplate.exchange(
				super.getFaireApiDomain("faire.api.product.list"), HttpMethod.GET, entity, ProductRequest.class);

		if (response != null && response.getBody() != null) {

			lst = response.getBody().getProducts();

			Predicate<Product> productPredicate = p -> (!p.getBrandId().equals(BRAND_ID)
					|| p.getName().indexOf(PRODUCT_NAME) == -1);
			lst.removeIf(productPredicate); // allow only specific brand id and product name.
		}

		return lst;
	}

}

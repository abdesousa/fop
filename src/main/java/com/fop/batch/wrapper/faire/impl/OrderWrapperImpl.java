package com.fop.batch.wrapper.faire.impl;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fop.batch.model.Order;
import com.fop.batch.model.OrderRequest;
import com.fop.batch.wrapper.faire.IOrderWrapper;

/**
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 * TODO Make a refactor to inject the RestTemplate (Autowired)
 * TODO Possibility to replace POJO by Optional class.
 */
@Service
public class OrderWrapperImpl extends RestUtils implements IOrderWrapper {

	@Override
	public List<Order> list() {

		HttpEntity<String> entity = new HttpEntity<String>(super.getPostHeaders());

		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<OrderRequest> response = restTemplate.exchange(
				super.getFaireApiDomain("faire.api.order.list"), HttpMethod.GET, entity, OrderRequest.class);

		return response.getBody().getOrders();
	}

	@Override
	public void accept(String orderId) {

		HttpEntity<String> entity = new HttpEntity<String>(super.getPostHeaders());

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity response = restTemplate.exchange(
				super.getFaireApiDomain("faire.api.order.items.availability",orderId), HttpMethod.PUT, entity, String.class);
	}

	@Override
	public List<Order> addShipment(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

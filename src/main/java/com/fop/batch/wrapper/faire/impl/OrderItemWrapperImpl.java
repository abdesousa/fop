package com.fop.batch.wrapper.faire.impl;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fop.batch.model.Item;
import com.fop.batch.model.Order;
import com.fop.batch.model.OrderRequest;
import com.fop.batch.wrapper.faire.IOrderItemWrapper;

/**
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 *         TODO Make a refactor to inject the RestTemplate (Autowired) TODO
 *         Possibility to replace POJO by Optional class.
 */
@Service
public class OrderItemWrapperImpl extends RestUtils implements IOrderItemWrapper {

	@Override
	public List<Order> availability(List<Item> items) {

		HttpEntity<String> entity = new HttpEntity<String>(generateJson(items).toString(), super.getPostHeaders());

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<OrderRequest> response = restTemplate.exchange(
				super.getFaireApiDomain("faire.api.order.items.availability"), HttpMethod.PUT, entity,
				OrderRequest.class);

		return response.getBody().getOrders();

	}

	/**
	 * Generate the json file dynamically.
	 * @param items
	 * @return
	 */
	private StringBuffer generateJson(List<Item> items) {
		StringBuffer ret = new StringBuffer();

		JSONObject orderItemJson = new JSONObject();
		try {
			for (Item item : items) {

				JSONObject orderItemJson2 = new JSONObject();

				orderItemJson2.put("available_quantity", item.getQuantity());
				orderItemJson2.put("discontinued", false);
				orderItemJson2.put("backordered_until", null);

				orderItemJson.put(item.getId().toString(), orderItemJson2);
			}
			ret.append(orderItemJson.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

}

package com.fop.batch.wrapper.faire;

import java.util.List;

import com.fop.batch.model.Item;
import com.fop.batch.model.Order;

/**
 * Interface to place the methods to wrap the calls at Faire api endpoints to
 * handle order item information.
 * 
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public interface IOrderItemWrapper {

	/**
	 * When backordering items, a new order will be created with the backordered
	 * items to be confirmed by the retailer.
	 * 
	 * POST https://www.faire.com/api/v1/orders/<ID>/items/availability
	 * 
	 * @param items
	 * @return
	 */
	public List<Order> availability(List<Item> items);

}

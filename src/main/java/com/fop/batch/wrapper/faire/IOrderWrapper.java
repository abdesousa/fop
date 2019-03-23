package com.fop.batch.wrapper.faire;

import java.util.List;

import com.fop.batch.model.Order;

/**
 * Interface to place the methods to wrap the calls at Faire api endpoints to
 * handle order information.
 * 
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public interface IOrderWrapper {

	/**
	 * This endpoint retrieves a list of orders, ordered ascending by updated_at.
	 * 
	 * GET https://www.faire.com/api/v1/orders
	 * 
	 * @param optionId
	 * @param availableQuantity
	 * @return
	 */
	public List<Order> list();

	/**
	 * This endpoint accepts an order and moves it to PROCESSING.
	 * 
	 * PUT https://www.faire.com/api/v1/orders/<ID>/processing

	 * @param orderid
	 * @return
	 */
	public void accept(String orderId);

	/**
	 * This endpoint adds shipments to an order and moves the state to PRE_TRANSIT.
	 * When one of the shipments is accepted by the carrier, the state will move to
	 * IN_TRANSIT.
	 * 
	 * POST https://www.faire.com/api/v1/orders/<ID>/shipments
	 * 
	 * @param id
	 * @return
	 */
	public List<Order> addShipment(String id);

}

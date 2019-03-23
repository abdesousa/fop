package com.fop.batch.configuration.steps.writer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.fop.batch.model.Item;
import com.fop.batch.model.Order;
import com.fop.batch.model.Product;
import com.fop.batch.model.ProductOption;
import com.fop.batch.wrapper.faire.IOrderItemWrapper;
import com.fop.batch.wrapper.faire.IOrderWrapper;
import com.fop.batch.wrapper.faire.IProductWrapper;

/**
 * Writer class to handle the logic about orders.
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public class OrderItemWriter implements ItemWriter<Order> {

	private static final Logger log = LoggerFactory.getLogger(OrderItemWriter.class);

	@Autowired
	private IOrderWrapper orderWrapper;

	@Autowired
	private IOrderItemWrapper orderItemWrapper;

	@Autowired
	private IProductWrapper productWrapper;

	public OrderItemWriter() {
	}

	@Override
	public void write(List<? extends Order> items) throws Exception {

		// get the list of products.
		List<Product> productList = productWrapper.list();

		List<Item> markedForBackorderingList = new ArrayList<Item>();

		for (Order orders : items) {

			for (Item item : orders.getItems()) {

				Product product = productList.stream().filter(prod -> item.getProductId().equals(prod.getId())).findAny().orElse(null);

				// check if there is inventory.
				if (product != null) {

					ProductOption po = product.getOptions().stream().filter(popt -> product.getId().equals(popt.getId())).findAny()
							.orElse(null);

					if (po != null) {

						if ((po.getAvailableQuantity() != null) && po.getAvailableQuantity().intValue() > 0) {

							// verify whether there is available items in stock.
							// if yes, accept the order.
							if (po.getAvailableQuantity().intValue() >= item.getQuantity().intValue()) {

								orderWrapper.accept(item.getOrderId());

								log.info("Order ID: " + item.getOrderId() + " was accepted sucessfully.");

							} else {

								markedForBackorderingList.add(item);
								log.info("Order ID: " + item.getOrderId() + ", OptionId: " + item.getProductOptionId()
										+ " was marked for Backordering.");

							}

						}

					}
				}

				// mark the items for markedForBackorderingList.
				if (markedForBackorderingList.size() > 0) {
					orderItemWrapper.availability(markedForBackorderingList);
				}
			}
		}

	}
}
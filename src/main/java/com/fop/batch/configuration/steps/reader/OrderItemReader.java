package com.fop.batch.configuration.steps.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.fop.batch.model.Order;
import com.fop.batch.wrapper.faire.IOrderWrapper;

/**
 * Class which contains the logic to extract the data from product api.
 * 
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public class OrderItemReader implements ItemReader<Order> {

	@Autowired
	private IOrderWrapper wrapper;

	private ItemReader<Order> delegate;

	@Override
	public Order read() throws Exception {
		if (delegate == null) {
			delegate = new IteratorItemReader<>(orders());
		}
		return delegate.read();
	}

	private List<Order> orders() {
		return wrapper.list();
	}
}

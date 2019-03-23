package com.fop.batch.wrapper.faire;

import java.util.List;

import com.fop.batch.model.Product;

/**
 * Interface to place the methods to wrap the calls at Faire api endpoints to handle products information.
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public interface IProductWrapper {

	/**
	 * Method responsible to invoke the get all products from Faire API.
	 * @return
	 */
	public List<Product> list();
	
}

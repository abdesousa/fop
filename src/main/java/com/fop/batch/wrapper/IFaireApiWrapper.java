package com.fop.batch.wrapper;

import java.util.List;

import com.fop.batch.model.Product;
import com.fop.batch.model.ProductOption;

/**
 * Interface to place the methods to wrap the calls at Faire api endpoints.
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public interface IFaireApiWrapper {

	/**
	 * Method responsible to invoke the get all products from Faire API.
	 * @return
	 */
	public List<Product> getAllProducts();
	
	
	/**
	 * 
	 * @param optionId
	 * @return
	 */
	public ProductOption updateProductOption(String optionId, Integer availableQuantity);
}

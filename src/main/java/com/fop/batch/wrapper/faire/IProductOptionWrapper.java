package com.fop.batch.wrapper.faire;

import com.fop.batch.model.ProductOption;

/**
 * Interface to place the methods to wrap the calls at Faire api endpoints to handle products Option information.
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public interface IProductOptionWrapper {

	/**
	 * PATCH https://www.faire.com/api/v1/products/options/<ID>
     * This endpoint is used to modify the available quantity of a product option.
	 * 
	 * @param optionId
	 * @return
	 */
	public ProductOption update(String optionId, Integer availableQuantity);
	
}

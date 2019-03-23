package com.fop.batch.configuration.steps.processor;

import org.springframework.batch.item.ItemProcessor;

import com.fop.batch.model.Product;

/**
 * 
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public class ProductItemProcessor implements ItemProcessor<Product, Product> {

	    @Override
	    public Product process(final Product product) throws Exception {
	        
	        final Product transformedProduct = product;

	        return transformedProduct;
	    }

	}
package com.fop.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.fop.batch.model.Product;

public class ProductItemProcessor implements ItemProcessor<Product, Product> {

	    @Override
	    public Product process(final Product product) throws Exception {
	        
	        final Product transformedProduct = product;

	        return transformedProduct;
	    }

	}
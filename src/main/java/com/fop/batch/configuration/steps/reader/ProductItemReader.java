package com.fop.batch.configuration.steps.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.fop.batch.model.Product;
import com.fop.batch.wrapper.faire.IProductWrapper;

/**
 * Class which contains the logic to extract the data from product api.
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public class ProductItemReader  implements ItemReader<Product> {
		 
	    private int nextProductIndex;
	    private List<Product> productData;
	    
	    @Autowired
	    private IProductWrapper wrapper;
	 
	    public ProductItemReader() {
	        nextProductIndex = 0;
	    }
	 
	    @Override
	    public Product read() throws Exception {
	        if (productDataIsNotInitialized()) {
	        	productData = wrapper.list();
	        }
	 
	        Product nextProduct = null;
	 
	        if (nextProductIndex < productData.size()) {
	        	nextProduct = productData.get(nextProductIndex);
	        	nextProductIndex++;
	        }
	 
	        return nextProduct;
	    }
	 
	    private boolean productDataIsNotInitialized() {
	        return this.productData == null;
	    }
	}

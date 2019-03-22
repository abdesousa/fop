package com.fop.batch.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.fop.batch.model.Product;
import com.fop.batch.wrapper.IFaireApiWrapper;

/**
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public class RESTProductReader  implements ItemReader<Product> {
		 
	    private int nextProductIndex;
	    private List<Product> productData;
	    
	    @Autowired
	    private IFaireApiWrapper wrapper;
	 
	    public RESTProductReader() {
	        nextProductIndex = 0;
	    }
	 
	    @Override
	    public Product read() throws Exception {
	        if (productDataIsNotInitialized()) {
	        	productData = wrapper.getAllProducts();
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

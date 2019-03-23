package com.fop.batch;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fop.batch.model.Product;
import com.fop.batch.model.ProductOption;
import com.fop.batch.wrapper.faire.IProductWrapper;
import com.fop.batch.wrapper.faire.impl.ProductWrapperImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductIntegrationTests {

    
    @TestConfiguration
    static class ProductWrapperTestContextConfiguration {
  
        @Bean
        public IProductWrapper productWrapper() {
            return new ProductWrapperImpl();
        }
        
    }
	
	@Autowired
	private IProductWrapper productWrapper;
	
	@Test
	public void testGetAllProducts() throws Exception {
		
    	List<Product> products = productWrapper.list();
    	
		for(Product product:products) {

			System.out.println(product.toString());
			
			for(ProductOption opt:product.getOptions()) {
				System.out.println(opt.toString());
			}
		
		}
	}
	
}

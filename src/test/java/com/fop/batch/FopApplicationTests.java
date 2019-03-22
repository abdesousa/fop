package com.fop.batch;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fop.batch.model.Product;
import com.fop.batch.model.ProductOption;
import com.fop.batch.model.ProductRequest;
import com.fop.batch.wrapper.IFaireApiWrapper;
import com.fop.batch.wrapper.impl.FaireApiWrapperImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class FopApplicationTests {

    private static final String BRAND_ID = "b_d2481b88";
    private static final String PRODUCT_NAME = "Tea Drops";
    
    @TestConfiguration
    static class FaireApiWrapperTestContextConfiguration {
  
        @Bean
        public IFaireApiWrapper FaireApiWrapper() {
            return new FaireApiWrapperImpl();
        }
    }
	
	@Autowired
	private IFaireApiWrapper wrapper;

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetQuestion() throws Exception {
		
    	List<Product> products = wrapper.getAllProducts();
    	
		for(Product product:products) {

			System.out.println(product.toString());
			
			for(ProductOption opt:product.getOptions()) {
				System.out.println(opt.toString());
			}
		
		}
	}
	
}

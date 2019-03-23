package com.fop.batch;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fop.batch.model.Item;
import com.fop.batch.model.Order;
import com.fop.batch.wrapper.faire.IOrderWrapper;
import com.fop.batch.wrapper.faire.impl.OrderWrapperImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class OrderIntegrationTests {

    
    @TestConfiguration
    static class OrderWrapperTestContextConfiguration {
  
        @Bean
        public IOrderWrapper orderWrapper() {
            return new OrderWrapperImpl();
        }
        
    }
	
	@Autowired
	private IOrderWrapper orderWrapper;
	
	@Test
	public void testGetAllOrders() throws Exception {
		
    	List<Order> orders = orderWrapper.list();
    	
		for(Order order:orders) {

			System.out.println(order.toString());
			
			for(Item item:order.getItems()) {
				System.out.println(item.toString());
			}
			
			System.out.println(order.getAddress());
		}
	}
	@Test
	public void testPutAcceptOrder() throws Exception {

		orderWrapper.accept("po_bm2czlhz");

	}
}

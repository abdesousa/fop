package com.fop.batch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fop.batch.model.ProductOption;
import com.fop.batch.wrapper.faire.IProductOptionWrapper;
import com.fop.batch.wrapper.faire.impl.ProductOptionWrapperImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductOptionIntegrationTests {

	@TestConfiguration
	static class ProductOptionWrapperTestContextConfiguration {

		@Bean
		public IProductOptionWrapper productOptionWrapper() {
			return new ProductOptionWrapperImpl();
		}

	}

	@Autowired
	private IProductOptionWrapper productOptionWrapper;

	@Before
	public void setUp() {

	}

	@Test
	public void testUpdateProductOption() throws Exception {

		ProductOption po = productOptionWrapper.update("po_bm2czlhz", 12);

		System.out.println(po.toString());

	}

}

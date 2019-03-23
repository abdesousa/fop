package com.fop.batch.configuration.steps.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.fop.batch.model.Product;
import com.fop.batch.model.ProductOption;
import com.fop.batch.wrapper.faire.IProductOptionWrapper;

/**
 * Writer class to handle the logic about products.
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public class ProductItemWriter implements ItemWriter<Product> {

	private static final Logger log = LoggerFactory.getLogger(ProductItemWriter.class);

	@Autowired
	private IProductOptionWrapper wrapper;

	public ProductItemWriter() {
	}

	@Override
	public void write(List<? extends Product> items) throws Exception {

		for (Product product : items) {

			for (ProductOption opt : product.getOptions()) {
				wrapper.update(opt.getId(), opt.getAvailableQuantity());
				log.info("ProductOption: ID:"+opt.getId()+", availableQuantity: "+opt.getAvailableQuantity()+" updated sucessfully.");
			}
		}

	}

}

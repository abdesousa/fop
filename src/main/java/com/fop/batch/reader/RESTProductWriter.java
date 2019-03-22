package com.fop.batch.reader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.fop.batch.model.Product;
import com.fop.batch.model.ProductOption;
import com.fop.batch.wrapper.IFaireApiWrapper;

/**
 * @author Alexandre Sousa (abdesousa@gmail.com)
 *
 */
public class RESTProductWriter implements ItemWriter<Product> {

	private static final Logger log = LoggerFactory.getLogger(RESTProductWriter.class);

	@Autowired
	private IFaireApiWrapper wrapper;

	public RESTProductWriter() {
	}

	@Override
	public void write(List<? extends Product> items) throws Exception {
		// TODO Auto-generated method stub

		for (Product product : items) {

			for (ProductOption opt : product.getOptions()) {
				wrapper.updateProductOption(opt.getId(), opt.getAvailableQuantity());
				log.info("ProductOption: ID:"+opt.getId()+", availableQuantity: "+opt.getAvailableQuantity()+" updated sucessfully.");
			}
		}

	}

}

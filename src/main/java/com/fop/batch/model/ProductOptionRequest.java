package com.fop.batch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductOptionRequest {

	@JsonProperty("available_quantity")
	private Integer availableQuantity;
	
	public ProductOptionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public ProductOptionRequest(Integer availableQuantity) {
		super();
		this.availableQuantity = availableQuantity;
	}

	
	
}

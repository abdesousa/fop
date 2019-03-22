package com.fop.batch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "page", "limit", "products" })
public class ProductRequest {

	@JsonProperty("page")
	private Integer page;
	
	@JsonProperty("limit")
	private Integer limit;

	@JsonProperty("products")
	private List<Product> products = null;

	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("page")
	public Integer getPage() {
		return page;
	}

	@JsonProperty("page")
	public void setPage(Integer page) {
		this.page = page;
	}

	@JsonProperty("limit")
	public Integer getLimit() {
		return limit;
	}

	@JsonProperty("limit")
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@JsonProperty("products")
	public List<Product> getProducts() {
		return products;
	}

	@JsonProperty("products")
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductRequest [page=" + page + ", limit=" + limit + ", products=" + products + "]";
	}

	
}

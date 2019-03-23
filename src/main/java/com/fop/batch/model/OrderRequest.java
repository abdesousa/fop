package com.fop.batch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "page", "limit", "orders" })
public class OrderRequest {
	
	@JsonProperty("page")
	private Integer page;
	@JsonProperty("limit")
	private Integer limit;
	@JsonProperty("orders")
	private List<Order> orders = null;
	
	public OrderRequest() {
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

	@JsonProperty("orders")
	public List<Order> getOrders() {
		return orders;
	}

	@JsonProperty("orders")
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
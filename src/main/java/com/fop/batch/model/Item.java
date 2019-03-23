package com.fop.batch.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "created_at", "updated_at", "order_id", "product_id", "product_option_id", "quantity", "sku",
		"price_cents", "product_name", "product_option_name", "includes_tester" })
public class Item {
	@JsonProperty("id")
	private String id;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("product_id")
	private String productId;
	@JsonProperty("product_option_id")
	private String productOptionId;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("sku")
	private String sku;
	@JsonProperty("price_cents")
	private Integer priceCents;
	@JsonProperty("product_name")
	private String productName;
	@JsonProperty("product_option_name")
	private String productOptionName;
	@JsonProperty("includes_tester")
	private Boolean includesTester;
	
	public Item() {
		super();
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("order_id")
	public String getOrderId() {
		return orderId;
	}

	@JsonProperty("order_id")
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@JsonProperty("product_id")
	public String getProductId() {
		return productId;
	}

	@JsonProperty("product_id")
	public void setProductId(String productId) {
		this.productId = productId;
	}

	@JsonProperty("product_option_id")
	public String getProductOptionId() {
		return productOptionId;
	}

	@JsonProperty("product_option_id")
	public void setProductOptionId(String productOptionId) {
		this.productOptionId = productOptionId;
	}

	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("sku")
	public String getSku() {
		return sku;
	}

	@JsonProperty("sku")
	public void setSku(String sku) {
		this.sku = sku;
	}

	@JsonProperty("price_cents")
	public Integer getPriceCents() {
		return priceCents;
	}

	@JsonProperty("price_cents")
	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}

	@JsonProperty("product_name")
	public String getProductName() {
		return productName;
	}

	@JsonProperty("product_name")
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@JsonProperty("product_option_name")
	public String getProductOptionName() {
		return productOptionName;
	}

	@JsonProperty("product_option_name")
	public void setProductOptionName(String productOptionName) {
		this.productOptionName = productOptionName;
	}

	@JsonProperty("includes_tester")
	public Boolean getIncludesTester() {
		return includesTester;
	}

	@JsonProperty("includes_tester")
	public void setIncludesTester(Boolean includesTester) {
		this.includesTester = includesTester;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", orderId=" + orderId
				+ ", productId=" + productId + ", productOptionId=" + productOptionId + ", quantity=" + quantity
				+ ", sku=" + sku + ", priceCents=" + priceCents + ", productName=" + productName
				+ ", productOptionName=" + productOptionName + ", includesTester=" + includesTester + "]";
	}
}

package com.fop.batch.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "product_id", "active", "name", "sku", "available_quantity", "backordered_until",
		"created_at", "updated_at" })
public class ProductOption {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("product_id")
	private String productId;
	
	@JsonProperty("active")
	private Boolean active;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("sku")
	private String sku;
	
	@JsonProperty("available_quantity")
	private Integer availableQuantity;
	
	@JsonProperty("backordered_until")
	private String backorderedUntil;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	public ProductOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("product_id")
	public String getProductId() {
		return productId;
	}

	@JsonProperty("product_id")
	public void setProductId(String productId) {
		this.productId = productId;
	}

	@JsonProperty("active")
	public Boolean getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(Boolean active) {
		this.active = active;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("sku")
	public String getSku() {
		return sku;
	}

	@JsonProperty("sku")
	public void setSku(String sku) {
		this.sku = sku;
	}

	@JsonProperty("available_quantity")
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	@JsonProperty("available_quantity")
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@JsonProperty("backordered_until")
	public String getBackorderedUntil() {
		return backorderedUntil;
	}

	@JsonProperty("backordered_until")
	public void setBackorderedUntil(String backorderedUntil) {
		this.backorderedUntil = backorderedUntil;
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

	@Override
	public String toString() {
		return "ProductOption [id=" + id + ", productId=" + productId + ", active=" + active + ", name=" + name
				+ ", sku=" + sku + ", availableQuantity=" + availableQuantity + ", backorderedUntil=" + backorderedUntil
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}

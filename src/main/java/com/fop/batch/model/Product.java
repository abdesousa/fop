package com.fop.batch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "brand_id", "short_description", "description", "wholesale_price_cents",
		"retail_price_cents", "active", "name", "unit_multiplier", "options", "created_at", "updated_at" })

@JsonFilter("myFilter")
public class Product {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("brand_id")
	private String brandId;
	
	@JsonProperty("short_description")
	private String shortDescription;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("wholesale_price_cents")
	private Integer wholesalePriceCents;
	
	@JsonProperty("retail_price_cents")
	private Integer retailPriceCents;
	
	@JsonProperty("active")
	private Boolean active;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("unit_multiplier")
	private Integer unitMultiplier;
	
	@JsonProperty("options")
	private List<ProductOption> options = null;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Product(String id, String brandId, String shortDescription, String description, Integer wholesalePriceCents,
			Integer retailPriceCents, Boolean active, String name, Integer unitMultiplier, List<ProductOption> options,
			String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.shortDescription = shortDescription;
		this.description = description;
		this.wholesalePriceCents = wholesalePriceCents;
		this.retailPriceCents = retailPriceCents;
		this.active = active;
		this.name = name;
		this.unitMultiplier = unitMultiplier;
		this.options = options;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("brand_id")
	public String getBrandId() {
		return brandId;
	}

	@JsonProperty("brand_id")
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	@JsonProperty("short_description")
	public String getShortDescription() {
		return shortDescription;
	}

	@JsonProperty("short_description")
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("wholesale_price_cents")
	public Integer getWholesalePriceCents() {
		return wholesalePriceCents;
	}

	@JsonProperty("wholesale_price_cents")
	public void setWholesalePriceCents(Integer wholesalePriceCents) {
		this.wholesalePriceCents = wholesalePriceCents;
	}

	@JsonProperty("retail_price_cents")
	public Integer getRetailPriceCents() {
		return retailPriceCents;
	}

	@JsonProperty("retail_price_cents")
	public void setRetailPriceCents(Integer retailPriceCents) {
		this.retailPriceCents = retailPriceCents;
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

	@JsonProperty("unit_multiplier")
	public Integer getUnitMultiplier() {
		return unitMultiplier;
	}

	@JsonProperty("unit_multiplier")
	public void setUnitMultiplier(Integer unitMultiplier) {
		this.unitMultiplier = unitMultiplier;
	}

	@JsonProperty("options")
	public List<ProductOption> getOptions() {
		return options;
	}
	
	@JsonProperty("options")
	public void setOptions(List<ProductOption> options) {
		this.options = options;
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
		return "Product [id=" + id + ", brandId=" + brandId + ", name=" + name + "]";
	}


	
}

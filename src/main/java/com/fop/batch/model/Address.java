package com.fop.batch.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "address1", "address2", "postal_code", "city", "state", "state_code", "phone_number",
		"country", "country_code", "company_name" })
public class Address {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("postal_code")
	private String postalCode;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("state_code")
	private String stateCode;
	@JsonProperty("phone_number")
	private String phoneNumber;
	@JsonProperty("country")
	private String country;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("company_name")
	private String companyName;
	
	public Address() {
		super();
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("address1")
	public String getAddress1() {
		return address1;
	}

	@JsonProperty("address1")
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@JsonProperty("address2")
	public String getAddress2() {
		return address2;
	}

	@JsonProperty("address2")
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@JsonProperty("postal_code")
	public String getPostalCode() {
		return postalCode;
	}

	@JsonProperty("postal_code")
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("state_code")
	public String getStateCode() {
		return stateCode;
	}

	@JsonProperty("state_code")
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@JsonProperty("phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}

	@JsonProperty("country_code")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@JsonProperty("company_name")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("company_name")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", address1=" + address1 + ", address2=" + address2 + ", postalCode="
				+ postalCode + ", city=" + city + ", state=" + state + ", stateCode=" + stateCode + ", phoneNumber="
				+ phoneNumber + ", country=" + country + ", countryCode=" + countryCode + ", companyName=" + companyName
				+ "]";
	}
	
	
}

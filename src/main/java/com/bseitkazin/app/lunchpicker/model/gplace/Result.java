package com.bseitkazin.app.lunchpicker.model.gplace;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result{
	
	private Geometry geometry;
	private String icon;
	private String id;
	private String name;
	@JsonProperty("opening_hours")
	private OpeningHour openingHours;
	@JsonProperty("price_level")
	private int priceLevel;
	private double rating;
	private List<String> types;
	@JsonProperty("user_ratings_total")
	private double userRatingsTotal;
	private String vicinity;
	
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OpeningHour getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(OpeningHour openingHours) {
		this.openingHours = openingHours;
	}
	public int getPriceLevel() {
		return priceLevel;
	}
	public void setPriceLevel(int priceLevel) {
		this.priceLevel = priceLevel;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public double getUserRatingsTotal() {
		return userRatingsTotal;
	}
	public void setUserRatingsTotal(double userRatingsTotal) {
		this.userRatingsTotal = userRatingsTotal;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	
}

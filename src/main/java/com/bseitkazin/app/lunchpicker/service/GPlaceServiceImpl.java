package com.bseitkazin.app.lunchpicker.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bseitkazin.app.lunchpicker.model.gplace.GPlace;

public class GPlaceServiceImpl implements GPlaceService{
	
	private static final String TYPE = "caffe";
	private static final int RADIUS = 500;
	
	@Value("${app.google.places.key}")
	private String key;
	
	public GPlace searhResult(String lat, String lng) {
		final String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
		
		UriComponentsBuilder uBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("location", lat+"," + lng)
				.queryParam("radius", RADIUS)
				.queryParam("type", TYPE)
				.queryParam("key", key);
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uBuilder.toUriString(), GPlace.class);
	}
	
	
}

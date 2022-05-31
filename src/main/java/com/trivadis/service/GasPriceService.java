package com.trivadis.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GasPriceService {

	public double getCurrentGasPricePerUnit() {
		return new RestTemplate().getForObject("http://localhost:8080/pricePerUnit", Double.class);
	}
}

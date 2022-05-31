package com.trivadis.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8080", value = "gasPriceService")
public interface GasPriceService {

	@GetMapping("/pricePerUnit")
	public double getCurrentPricePerUnit();
}

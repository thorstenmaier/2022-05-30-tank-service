package com.trivadis.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TankCapacityRepository {

	private Map<Long, Long> tankCapacities = new HashMap<>();

	public long getCapacity(long tankId) {
		return tankCapacities.get(tankId);
	}

	public void addTankCapacity(long tankId, long capacity) {
		tankCapacities.put(tankId, capacity);
	}
}

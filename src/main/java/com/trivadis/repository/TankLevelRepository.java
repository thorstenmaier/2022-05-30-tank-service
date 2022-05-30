package com.trivadis.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TankLevelRepository {

	private Map<Long, Long> tankLevels = new HashMap<>();

	public long getLevel(long tankId) {
		return tankLevels.get(tankId);
	}

	public void addTankLevel(long tankId, long level) {
		tankLevels.put(tankId, level);
	}

	public void setLevel(long tankId, long newLevel) {
		tankLevels.put(tankId, newLevel);
	}
}

package com.trivadis.service;

import org.springframework.stereotype.Component;

import com.trivadis.repository.TankCapacityRepository;
import com.trivadis.repository.TankLevelRepository;

@Component
public class RelativeTankLevelService {

	private TankCapacityRepository tankCapacityRepository;

	private TankLevelRepository tankLevelRepository;

	public RelativeTankLevelService(TankCapacityRepository tankCapacityRepository,
			TankLevelRepository tankLevelRepository) {

		this.tankCapacityRepository = tankCapacityRepository;
		this.tankLevelRepository = tankLevelRepository;

	}

	public double getRelativeTankLevel(long tankId) {
		long level = tankLevelRepository.getLevel(tankId);
		long capacity = tankCapacityRepository.getCapacity(tankId);
		return (1.0 * level) / capacity;
	}
}

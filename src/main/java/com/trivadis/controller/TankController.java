package com.trivadis.controller;

import org.springframework.stereotype.Component;

import com.trivadis.dto.TankDto;
import com.trivadis.repository.TankCapacityRepository;
import com.trivadis.repository.TankLevelRepository;
import com.trivadis.service.RelativeTankLevelService;

@Component
public class TankController {

	private RelativeTankLevelService relativeTankLevelService;
	private TankCapacityRepository tankCapacityRepository;
	private TankLevelRepository tankLevelRepository;

	public TankController(RelativeTankLevelService relativeTankLevelService,
			TankCapacityRepository tankCapacityRepository, TankLevelRepository tankLevelRepository) {
		this.relativeTankLevelService = relativeTankLevelService;
		this.tankCapacityRepository = tankCapacityRepository;
		this.tankLevelRepository = tankLevelRepository;
	}

	public TankDto getTankDetails(long tankId) {

		TankDto tankDto = new TankDto();
		tankDto.setTankId(tankId);
		tankDto.setLevel(tankLevelRepository.getLevel(tankId));
		tankDto.setCapacity(tankCapacityRepository.getCapacity(tankId));
		tankDto.setRelativeLevel(relativeTankLevelService.getRelativeTankLevel(tankId));
		return tankDto;
	}

}

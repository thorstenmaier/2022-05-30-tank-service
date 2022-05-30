package com.trivadis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trivadis.dto.TankDto;
import com.trivadis.repository.TankCapacityRepository;
import com.trivadis.repository.TankLevelRepository;
import com.trivadis.service.RelativeTankLevelService;

//@Component
@RestController
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

	@GetMapping("/tanks/{id}")
	public TankDto getTankDetails(@PathVariable("id") long tankId) {
		TankDto tankDto = new TankDto();
		tankDto.setTankId(tankId);
		tankDto.setLevel(tankLevelRepository.getLevel(tankId));
		tankDto.setCapacity(tankCapacityRepository.getCapacity(tankId));
		tankDto.setRelativeLevel(relativeTankLevelService.getRelativeTankLevel(tankId));
		return tankDto;
	}

	// http://localhost:8081/tanks?id=1
	@GetMapping("/tanks")
	public TankDto getTankDetailsParam(@RequestParam("id") long tankId) {
		return getTankDetails(tankId);
	}

}

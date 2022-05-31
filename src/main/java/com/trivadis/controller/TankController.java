package com.trivadis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trivadis.dto.TankDto;
import com.trivadis.repository.TankCapacityRepository;
import com.trivadis.repository.TankLevelRepository;
import com.trivadis.service.GasPriceService;
import com.trivadis.service.RelativeTankLevelService;

//@Component
@RestController
public class TankController {

	private RelativeTankLevelService relativeTankLevelService;
	private TankCapacityRepository tankCapacityRepository;
	private TankLevelRepository tankLevelRepository;
	private GasPriceService gasPriceService;

	public TankController(RelativeTankLevelService relativeTankLevelService,
			TankCapacityRepository tankCapacityRepository, TankLevelRepository tankLevelRepository,
			GasPriceService gasPriceService) {
		this.relativeTankLevelService = relativeTankLevelService;
		this.tankCapacityRepository = tankCapacityRepository;
		this.tankLevelRepository = tankLevelRepository;
		this.gasPriceService = gasPriceService;
	}

	@GetMapping("/tanks/{id}")
	public TankDto getTankDetails(@PathVariable("id") long tankId) {
		TankDto tankDto = new TankDto();
		tankDto.setTankId(tankId);
		tankDto.setLevel(tankLevelRepository.getLevel(tankId));
		tankDto.setCapacity(tankCapacityRepository.getCapacity(tankId));
		tankDto.setRelativeLevel(relativeTankLevelService.getRelativeTankLevel(tankId));
		tankDto.setCurrentValueInEur(gasPriceService.getCurrentGasPricePerUnit() * tankDto.getLevel());
		return tankDto;
	}

	// http://localhost:8081/tanks?id=1
	@GetMapping("/tanks")
	public TankDto getTankDetailsParam(@RequestParam(value = "id", required = false, defaultValue = "1") long tankId) {
		return getTankDetails(tankId);
	}

	// http://localhost:8081/tanks/setLevel?id=1&level=3000
	@GetMapping("/tanks/setLevel")
	public void setLevel(@RequestParam("id") long tankId, @RequestParam("level") long newLevel) {
		tankLevelRepository.setLevel(tankId, newLevel);
	}

	@PostMapping("/tanks")
	public void createNewTank(@RequestBody TankDto tankDto) {
		tankLevelRepository.addTankLevel(tankDto.getTankId(), tankDto.getLevel());
		tankCapacityRepository.addTankCapacity(tankDto.getTankId(), tankDto.getCapacity());
	}

}

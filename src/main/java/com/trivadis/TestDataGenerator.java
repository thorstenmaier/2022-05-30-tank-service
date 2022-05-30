package com.trivadis;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.trivadis.repository.TankCapacityRepository;
import com.trivadis.repository.TankLevelRepository;

@Component
@Profile("test")
public class TestDataGenerator {

	@Autowired
	private TankCapacityRepository tankCapacityRepository;

	@Autowired
	private TankLevelRepository tankLevelRepository;

	@PostConstruct
	public void run() {
		tankCapacityRepository.addTankCapacity(1l, 30000l);
		tankLevelRepository.addTankLevel(1l, 10000l);
	}
}

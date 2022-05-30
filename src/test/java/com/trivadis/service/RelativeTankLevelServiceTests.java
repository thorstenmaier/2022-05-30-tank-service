package com.trivadis.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class RelativeTankLevelServiceTests {

	@Autowired
	private RelativeTankLevelService relativeTankLevelService;

	@Test
	void testGetRelativeTankLevel() {
		double tankLevel = relativeTankLevelService.getRelativeTankLevel(1l);
		System.out.println(tankLevel);
		assertEquals(0.33, tankLevel, 0.01d);
	}
}

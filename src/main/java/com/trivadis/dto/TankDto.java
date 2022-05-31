package com.trivadis.dto;

// POJO
public class TankDto {

	private long tankId;
	private long capacity;
	private long level;
	private double relativeLevel;
	private double currentValueInEur;

	public long getTankId() {
		return tankId;
	}

	public void setTankId(long tankId) {
		this.tankId = tankId;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public double getRelativeLevel() {
		return relativeLevel;
	}

	public void setRelativeLevel(double relativeLevel) {
		this.relativeLevel = relativeLevel;
	}

	public double getCurrentValueInEur() {
		return currentValueInEur;
	}

	public void setCurrentValueInEur(double currentValueInEur) {
		this.currentValueInEur = currentValueInEur;
	}

}

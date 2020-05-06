package com.mitesh.junit.JUnitSpringBoot.business;

import com.mitesh.junit.JUnitSpringBoot.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService dataService;
	
	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}
	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data=dataService.retrieveAllData();
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
}

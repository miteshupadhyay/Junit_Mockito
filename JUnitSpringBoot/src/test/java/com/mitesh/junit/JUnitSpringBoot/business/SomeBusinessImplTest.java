package com.mitesh.junit.JUnitSpringBoot.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {

	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl businessImpl=new SomeBusinessImpl();
		int actual=businessImpl.calculateSum(new int[] {1,2,3});
		int expectedResult=6;
		assertEquals(expectedResult, actual);
	
	}
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl businessImpl=new SomeBusinessImpl();
		int actual=businessImpl.calculateSum(new int[] {});
		int expectedResult=0;
		assertEquals(expectedResult, actual);
	
	}
	@Test
	public void calculateSum_One() {
		SomeBusinessImpl businessImpl=new SomeBusinessImpl();
		int actual=businessImpl.calculateSum(new int[] {1});
		int expectedResult=1;
		assertEquals(expectedResult, actual);
	
	}
}

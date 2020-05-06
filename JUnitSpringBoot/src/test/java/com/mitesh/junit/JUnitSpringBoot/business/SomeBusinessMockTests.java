package com.mitesh.junit.JUnitSpringBoot.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mitesh.junit.JUnitSpringBoot.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTests {

	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	@Mock
	SomeDataService someMockDataService;

	@Test
	public void calculateSum_usingDataServiceEmpty() {
		when(someMockDataService.retrieveAllData()).thenReturn(new int[] {});
		int actualData=businessImpl.calculateSumUsingDataService();
		int expectedResult=0;
		assertEquals(expectedResult, actualData);	
	}
	@Test
	public void calculateSum_usingDataServiceOne() {
		when(someMockDataService.retrieveAllData()).thenReturn(new int[] {3});
		int actualData=businessImpl.calculateSumUsingDataService();
		int expectedResult=3;
		assertEquals(expectedResult, actualData);	
	}
	@Test
	public void calculateSum_usingDataService() {
		when(someMockDataService.retrieveAllData()).thenReturn(new int[] {3,3,3});
		int actualData=businessImpl.calculateSumUsingDataService();
		int expectedResult=9;
		assertEquals(expectedResult, actualData);	
	}
	
	
	
}

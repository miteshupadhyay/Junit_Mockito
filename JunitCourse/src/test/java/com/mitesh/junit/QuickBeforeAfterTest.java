package com.mitesh.junit;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@Before
	public void setup() {
		System.out.println("Before");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	

	@Test
	public void test2() {
		System.out.println("Test 2");
	}

	@After
	public void end() {
		System.out.println("end");
	}
	
	@Test
	public void testArraySortingEquality() {		
		int[] number= {11,2,23,4};
		int[] expectced= {2,4,11,23};
		Arrays.sort(number);		
		assertArrayEquals(expectced, number);	
	}
	
	@Test(expected = NullPointerException.class)
	public void testArrayForException() {		
		int[] number=null;
		Arrays.sort(number);		
	}
	
	@Test(timeout = 100)
	public void testArray_performance() {		
		int[] number= {11,2,23,4};
		for(int i=1;i<10000;i++)
		{
			number[0]=i;
			Arrays.sort(number);
		}
	}
	
	
	
	@AfterClass
	public static void enClass() {
		System.out.println("end class");
	}
}

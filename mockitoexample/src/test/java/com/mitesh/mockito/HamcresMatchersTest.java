package com.mitesh.mockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcresMatchersTest {

	@Test
	public void test() {
		
		List<Integer> scores=Arrays.asList(99,100,54,39);
	
		//scores has 4 items
		assertThat(scores,hasSize(4));
		assertThat(scores,hasItems(99,54));
		assertThat(scores,everyItem(greaterThan(30)));
		
		
		//String
		assertThat("",isEmptyString());
		assertThat(null,isEmptyOrNullString());
		
		//Arrays
		Integer[] marks= {1,2,3,4};
		
		assertThat(marks, arrayWithSize(4));
		assertThat(marks, arrayContaining(1,2,3,4));
		assertThat(marks, arrayContainingInAnyOrder(2,1,4,3));
		
		
	}

}

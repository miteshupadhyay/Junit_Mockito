package com.mitesh.mockito.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void mockListSize() 
	{		
		List list=mock(List.class);
		when(list.size()).thenReturn(3);
		assertEquals(3,list.size());	
	}
	
	@Test
	public void mockListSize_returnMultipleValues() 
	{		
		List list=mock(List.class);
		when(list.size()).thenReturn(3).thenReturn(4);
		assertEquals(3,list.size());	
		assertEquals(4,list.size());	
	}
	
	@Test
	public void mockListGet() 
	{		
		List list=mock(List.class);
		when(list.get(anyInt())).thenReturn("ABC");
		assertEquals("ABC",list.get(0));
		assertEquals("ABC",list.get(1));
	}
	
	@Test(expected = RuntimeException.class)
	public void mockListGet_throwException() 
	{		
		List list=mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException("anything"));
		list.get(0);
	}
	
	
}

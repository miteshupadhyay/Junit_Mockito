package com.mitesh.junit.JUnitSpringBoot.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	List<String> mockList=mock(List.class);

	@Test
	public void size_basic()
	{
		when(mockList.size()).thenReturn(5);
		assertEquals(5,mockList.size());
	}
	@Test
	public void returnDifferentValues()
	{
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mockList.size());
		assertEquals(10,mockList.size());
	}
	@Test
	public void returnWithParameters()
	{
		when(mockList.get(0)).thenReturn("Test");
		assertEquals("Test",mockList.get(0));
	}
	
	@Test
	public void returnWithGenericParameters()
	{
		when(mockList.get(anyInt())).thenReturn("Test");
		assertEquals("Test",mockList.get(3));
	}
	
	@Test
	public void verificationBasics()
	{
		String value1=mockList.get(0);
		String value2=mockList.get(1);
		
		verify(mockList).get(0);
		verify(mockList,times(2)).get(anyInt());
		verify(mockList,atLeastOnce()).get(anyInt());
		verify(mockList,atLeast(1)).get(anyInt());
		verify(mockList,atMost(2)).get(anyInt());
		verify(mockList,never()).get(2);
	}
	
	@Test
	public void argumentCapturing()
	{
		mockList.add("SampleValue1");
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());
		assertEquals("SampleValue1",captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing()
	{
		mockList.add("SampleValue1");
		mockList.add("SampleValue2");
		
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		
		verify(mockList,times(2)).add(captor.capture());
		
		List<String> allValues=captor.getAllValues();
		
		assertEquals("SampleValue1",allValues.get(0));
		assertEquals("SampleValue2",allValues.get(1));
	}
	
	@Test
	public void mocking()
	{
		ArrayList arrayListMock=mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));
		System.out.println(arrayListMock.size());
		arrayListMock.add("test1");
		arrayListMock.add("test2");
		System.out.println(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
	}
	
	@Test
	public void spying()
	{
		ArrayList arrayListMock=spy(ArrayList.class);
		arrayListMock.add("test1");
		System.out.println(arrayListMock.get(0));
		System.out.println(arrayListMock.size());
		arrayListMock.add("test2");
		System.out.println(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
	}
	
}

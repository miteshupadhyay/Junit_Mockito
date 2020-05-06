package com.mitesh.junit.JUnitSpringBoot.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mitesh.junit.JUnitSpringBoot.model.Item;
import com.mitesh.junit.JUnitSpringBoot.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService itemBusinessService;

	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void retrieveAllItems_basic()
	{
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(10,"Item2",10,10),new Item(11,"Item3",5,2)));
		
		List<Item> retrieveAllItems = itemBusinessService.retrieveAllItems();
		assertEquals(100, retrieveAllItems.get(0).getValue());
		assertEquals(10, retrieveAllItems.get(1).getValue());
	}
}

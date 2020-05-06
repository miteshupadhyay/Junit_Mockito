package com.mitesh.junit.JUnitSpringBoot.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitesh.junit.JUnitSpringBoot.model.Item;
import com.mitesh.junit.JUnitSpringBoot.repository.ItemRepository;


@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item retreiveHardCodedItem()
	{
		return new Item(1,"Ball",10, 1000);
	}
	
	
	public List<Item> retrieveAllItems()
	{
		 List<Item> items = itemRepository.findAll();
		 for(Item item:items) {
			 item.setValue(item.getPrice()*item.getQuantity());
		 }		 
		 return items;
	}
}

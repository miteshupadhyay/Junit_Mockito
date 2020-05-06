package com.mitesh.junit.JUnitSpringBoot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mitesh.junit.JUnitSpringBoot.business.ItemBusinessService;
import com.mitesh.junit.JUnitSpringBoot.model.Item;


@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService itemService;
	
	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder requestBuilder=MockMvcRequestBuilders
										.get("/dummy-item")
										.accept(MediaType.APPLICATION_JSON);
		
			MvcResult result = mockMvc.perform(requestBuilder)
									  .andExpect(status().isOk())
									  .andExpect(content().json("{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 100}"))
									  .andReturn();
			//assertEquals("Hello-World", result.getResponse().getContentAsString());
	}

	@Test
	public void itemFromBusinessService_basic() throws Exception {
		
		when(itemService.retreiveHardCodedItem()).thenReturn(new Item(10,"Item2",10, 10));
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders
										.get("/item-from-business-service")
										.accept(MediaType.APPLICATION_JSON);
		
			MvcResult result = mockMvc.perform(requestBuilder)
									  .andExpect(status().isOk())
									  .andExpect(content().json("{id: 10,name:Item2,price: 10}"))
									  .andReturn();
			//assertEquals("Hello-World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		
		when(itemService.retrieveAllItems()).thenReturn(Arrays.asList(new Item(10,"Item2",10,10),
																	new Item(11,"Item3",5,2)));
				
		RequestBuilder requestBuilder=MockMvcRequestBuilders
										.get("/all-items-from-database")
										.accept(MediaType.APPLICATION_JSON);
		
			MvcResult result = mockMvc.perform(requestBuilder)
									  .andExpect(status().isOk())
									  .andExpect(content().json("[{id:10,name:Item2,price:10},{id:11,name:Item3,price:5}]"))
									  .andReturn();
			//assertEquals("Hello-World", result.getResponse().getContentAsString());
	}
}

package com.mitesh.mockito.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mitesh.mockito.service.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplAnnotationsTest {

	@Mock
	TodoService mockTodoService;
	
	@InjectMocks
	TodoServiceImpl todoServiceImpl;
	
	@Test
	public void testretrieveTodosRelatedToSpring_usingMock() {
		
		List<String> todos=Arrays.asList("Spring","Spring Boot");
		when(mockTodoService.retrieveTodos("DUMMY")).thenReturn(todos);
		List<String> filteredTodos=todoServiceImpl.retrieveTodosRelatedToSpring("DUMMY");
		assertEquals(2,filteredTodos.size());
		
	}
	@Test
	public void testretrieveTodosRelatedToSpring_usingMockEmptyList() {
		
		List<String> todos=Arrays.asList();
		when(mockTodoService.retrieveTodos("DUMMY")).thenReturn(todos);
		List<String> filteredTodos=todoServiceImpl.retrieveTodosRelatedToSpring("DUMMY");
		assertEquals(0,filteredTodos.size());		
	}	
	
	@Test
	public void testdeleteTodosNotRelatedToSpring() {
		
		List<String> todos=Arrays.asList();
		when(mockTodoService.retrieveTodos("DUMMY")).thenReturn(todos);
		List<String> filteredTodos=todoServiceImpl.retrieveTodosRelatedToSpring("DUMMY");
		assertEquals(0,filteredTodos.size());
		
	}	
}

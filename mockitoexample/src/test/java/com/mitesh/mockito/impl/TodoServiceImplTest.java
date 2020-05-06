package com.mitesh.mockito.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mitesh.mockito.service.TodoService;

public class TodoServiceImplTest {

	@Test
	public void testretrieveTodosRelatedToSpring_usingMock() {
		
		TodoService mockTodoService=mock(TodoService.class);
		List<String> todos=Arrays.asList("Spring","Spring Boot");
		
		when(mockTodoService.retrieveTodos("DUMMY")).thenReturn(todos);
		TodoServiceImpl todoServiceImpl=new TodoServiceImpl(mockTodoService);
		
		List<String> filteredTodos=todoServiceImpl.retrieveTodosRelatedToSpring("DUMMY");
		assertEquals(2,filteredTodos.size());
		
	}
	@Test
	public void testretrieveTodosRelatedToSpring_usingMockEmptyList() {
		
		TodoService mockTodoService=mock(TodoService.class);
		List<String> todos=Arrays.asList("Spring","Spring Boot");
		when(mockTodoService.retrieveTodos("DUMMY")).thenReturn(todos);
		TodoServiceImpl todoServiceImpl=new TodoServiceImpl(mockTodoService);
		
		List<String> filteredTodos=todoServiceImpl.retrieveTodosRelatedToSpring("DUMMY");
		assertEquals(0,filteredTodos.size());
		
	}
	
	
	@Test
	public void testdeleteTodosNotRelatedToSpring() {
		
		TodoService mockTodoService=mock(TodoService.class);
		List<String> todos=Arrays.asList();
		
		when(mockTodoService.retrieveTodos("DUMMY")).thenReturn(todos);
		TodoServiceImpl todoServiceImpl=new TodoServiceImpl(mockTodoService);
		
		List<String> filteredTodos=todoServiceImpl.retrieveTodosRelatedToSpring("DUMMY");
		assertEquals(0,filteredTodos.size());
		
	}	
}

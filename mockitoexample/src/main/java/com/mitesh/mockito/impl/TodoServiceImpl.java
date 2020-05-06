package com.mitesh.mockito.impl;

import java.util.ArrayList;
import java.util.List;

import com.mitesh.mockito.service.TodoService;

public class TodoServiceImpl {

	private TodoService todoService;

	TodoServiceImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {

		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);

		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user) {

		List<String> allTodos = todoService.retrieveTodos(user);

		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}

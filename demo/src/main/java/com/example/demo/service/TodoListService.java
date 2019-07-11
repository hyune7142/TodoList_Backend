package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.TodoList;
@Transactional
public interface TodoListService {
	
	public ArrayList<TodoList> getTodoList();

	public void updateItem(TodoList todoitem);

}
